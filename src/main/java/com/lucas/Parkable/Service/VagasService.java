package com.lucas.Parkable.Service;

import com.lucas.Parkable.DTOs.Mappers.VagaMapper;
import com.lucas.Parkable.DTOs.VagaRequestDTO;
import com.lucas.Parkable.DTOs.VagaResponseDTO;
import com.lucas.Parkable.Models.VagaModel;
import com.lucas.Parkable.Repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class VagasService {

    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private VagaMapper vagaMapper;

    public VagaResponseDTO adicionarVaga(VagaRequestDTO vagaRequestDTO){
        VagaModel novaVaga = new VagaModel();
        novaVaga.setCodigoVaga(vagaRequestDTO.codigoVaga());
        novaVaga.setOcupada(false);
        return vagaMapper.map(vagaRepository.save(novaVaga));
    }

    public List<VagaResponseDTO> listarTodasVagas(){
        List<VagaModel> vagasEncontradasModel = vagaRepository.findAll();
        return vagasEncontradasModel.stream()
                .map(vagaMapper :: map)
                .collect(Collectors.toList());
    }

    public List<VagaResponseDTO> listarVagasOcupadas(){
        List<VagaModel> vagasEncontradasModel = vagaRepository.findByOcupadaIsTrue();
        return vagasEncontradasModel.stream()
                .map(vagaMapper::map)
                .collect(Collectors.toList());
    }

    public List<VagaResponseDTO> listarVagasLivres(){
        List<VagaModel> vagasEncontradasModel = vagaRepository.findByOcupadaIsFalse();
        return vagasEncontradasModel.stream()
                .map (vagaMapper :: map)
                .collect(Collectors.toList());
    }

    public void  deletarVaga(Long id){
        if (vagaRepository.existsById(id)){
            vagaRepository.deleteById(id);
        }
    }

}
