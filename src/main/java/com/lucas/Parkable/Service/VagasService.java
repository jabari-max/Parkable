package com.lucas.Parkable.Service;

import com.lucas.Parkable.Models.VagaModel;
import com.lucas.Parkable.Repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class VagasService {

    @Autowired
    private VagaRepository vagaRepository;

    private VagaModel adicionarVaga(VagaModel vagaModel){
        return vagaRepository.save(vagaModel);
    }

    private List<VagaModel> listarTodasVagas(){
        return vagaRepository.findAll();
    }

    private List<VagaModel> listarVagasOcupadas(){
        return vagaRepository.findByOcupadaIsTrue();
    }

    private List<VagaModel> listarVagasLivres(){
        return vagaRepository.findByOcupadaIsFalse();
    }

    private void  deletarVaga(Long id){
        if (vagaRepository.existsById(id)){
            vagaRepository.deleteById(id);
        }
    }

}
