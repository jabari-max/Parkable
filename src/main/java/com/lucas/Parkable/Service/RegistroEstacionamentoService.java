package com.lucas.Parkable.Service;

import com.lucas.Parkable.DTOs.Mappers.RegistroEstacionamentoMapper;
import com.lucas.Parkable.DTOs.RegistroEstacionamento.RegistroEstacionamentoRequestDTO;
import com.lucas.Parkable.DTOs.RegistroEstacionamento.RegistroEstacionamentoResponseDTO;
import com.lucas.Parkable.Enums.TipoVeiculo;
import com.lucas.Parkable.Models.RegistroEstacionamentoModel;
import com.lucas.Parkable.Models.VagaModel;
import com.lucas.Parkable.Repository.RegistroEstacionamentoRepository;
import com.lucas.Parkable.Repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistroEstacionamentoService {

    @Autowired
    private RegistroEstacionamentoRepository registroEstacionamentoRepository;
    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private RegistroEstacionamentoMapper registroEstacionamentoMapper;


    public RegistroEstacionamentoResponseDTO registrarEntrada(RegistroEstacionamentoRequestDTO registroEstacionamentoRequestDTO) {
        Optional<VagaModel> vagaDesejadaModel = vagaRepository.findById(registroEstacionamentoRequestDTO.vagaId());

        if (vagaDesejadaModel.isPresent()) {
            if (!vagaDesejadaModel.get().isOcupada()) {
                VagaModel vagaEncontradaModel = vagaDesejadaModel.get();

                RegistroEstacionamentoModel novoRegistroModel = new RegistroEstacionamentoModel();
                novoRegistroModel.setPlaca(registroEstacionamentoRequestDTO.placa());
                novoRegistroModel.setHorarioEntrada(LocalDateTime.now());
                novoRegistroModel.setVaga(vagaEncontradaModel);
                novoRegistroModel.setTipoVeiculo(registroEstacionamentoRequestDTO.tipoVeiculo());
                vagaEncontradaModel.setOcupada(true);

                vagaRepository.save(vagaEncontradaModel);

                return registroEstacionamentoMapper.map(registroEstacionamentoRepository.save(novoRegistroModel));
            }
            return null;
        }
        return null;
    }

    public RegistroEstacionamentoResponseDTO registrarSaida(Long id) {
        Optional<RegistroEstacionamentoModel> veiculo = registroEstacionamentoRepository.findById(id);

        if (veiculo.isPresent()) {
            RegistroEstacionamentoModel veiculoEncontrado = veiculo.get();
            veiculoEncontrado.setHorarioSaida(LocalDateTime.now());

            double taxaFixa;
            double taxaHoraExtra;

            if (veiculoEncontrado.getTipoVeiculo() == TipoVeiculo.CARRO) {
                taxaFixa = 5.0;
                taxaHoraExtra = 3.0;
            } else {
                taxaFixa = 3.0;
                taxaHoraExtra = 2.0;
            }

            Duration duracao = Duration.between(veiculoEncontrado.getHorarioEntrada(), veiculoEncontrado.getHorarioSaida());
            long minutosDaDuracao = duracao.toMinutes();

            if (minutosDaDuracao <= 60) {
                veiculoEncontrado.setValor(taxaFixa);
            } else {
                double minutosExtras = minutosDaDuracao - 60;
                double valor = taxaFixa + taxaHoraExtra * ((minutosExtras + 59) / 60);
                veiculoEncontrado.setValor(valor);
            }

            VagaModel vagaRespectiva = veiculoEncontrado.getVaga();
            vagaRespectiva.setOcupada(false);
            vagaRepository.save(vagaRespectiva);

            return registroEstacionamentoMapper.map(registroEstacionamentoRepository.save(veiculoEncontrado));

        }
        return null;
    }

    public List<RegistroEstacionamentoResponseDTO> exibirRegistros(){
        List<RegistroEstacionamentoModel> registrosModel = registroEstacionamentoRepository.findAll();
        return registrosModel.stream()
                .map(registroEstacionamentoMapper::map)
                .collect(Collectors.toList());
    }

    public List<RegistroEstacionamentoResponseDTO> exibirRegistrosTipo(TipoVeiculo tipoVeiculo){
        List<RegistroEstacionamentoModel> registrosModel = registroEstacionamentoRepository.findByTipoVeiculo(tipoVeiculo);
        return registrosModel.stream()
                .map(registroEstacionamentoMapper::map)
                .collect(Collectors.toList());
    }

    public List<RegistroEstacionamentoResponseDTO> exibirRegistrosPlaca(String placa) {
        List<RegistroEstacionamentoModel> registrosModel =  registroEstacionamentoRepository.findByPlaca(placa);
        return registrosModel.stream()
                .map(registroEstacionamentoMapper::map)
                .collect(Collectors.toList());
    }

    public List<RegistroEstacionamentoResponseDTO> exibirRegistrosPresentes() {
        List<RegistroEstacionamentoModel> registrosEncontrados = registroEstacionamentoRepository.findByHorarioSaidaIsNull();
        return registrosEncontrados.stream()
                .map(registroEstacionamentoMapper::map)
                .collect(Collectors.toList());
    }

}