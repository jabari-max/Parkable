package com.lucas.Parkable.Service;

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

@Service
public class RegistroEstacionamentoService {

    @Autowired
    private RegistroEstacionamentoRepository registroEstacionamentoRepository;
    @Autowired
    private VagaRepository vagaRepository;


    public RegistroEstacionamentoModel registrarEntrada(String placa, Long vagaId, TipoVeiculo tipoVeiculo){

        Optional<VagaModel> vagaDesejada = vagaRepository.findById(vagaId);

        if (vagaDesejada.isPresent()) {
            if (!vagaDesejada.get().isOcupada()){
                VagaModel vagaEncontrada = vagaDesejada.get();

                RegistroEstacionamentoModel novoRegistro = new RegistroEstacionamentoModel();
                novoRegistro.setPlaca(placa);
                novoRegistro.setHorarioEntrada(LocalDateTime.now());
                novoRegistro.setVaga(vagaEncontrada);
                novoRegistro.setTipoVeiculo(tipoVeiculo);
                vagaEncontrada.setOcupada(true);
                vagaRepository.save(vagaEncontrada);

                return registroEstacionamentoRepository.save(novoRegistro);
            } return null;
        } return null;

    }

    public RegistroEstacionamentoModel registrarSaida (Long id) {
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

            return registroEstacionamentoRepository.save(veiculoEncontrado);

        } return null;
    }

    public List<RegistroEstacionamentoModel> exibirRegistros(){
        return registroEstacionamentoRepository.findAll();
    }

    public List<RegistroEstacionamentoModel> exibirRegistrosTipo(TipoVeiculo tipoVeiculo){
        return registroEstacionamentoRepository.findByTipoVeiculo(tipoVeiculo);
    }

    public List<RegistroEstacionamentoModel> exibirRegistrosPlaca (String placa){
        return registroEstacionamentoRepository.findByPlaca(placa);
    }
}
