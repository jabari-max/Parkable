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

    public VagaModel adicionarVaga(String codigoVaga){
        VagaModel novaVaga = new VagaModel();
        novaVaga.setCodigoVaga(codigoVaga);
        novaVaga.setOcupada(false);
        return vagaRepository.save(novaVaga);
    }

    public List<VagaModel> listarTodasVagas(){
        return vagaRepository.findAll();
    }

    public List<VagaModel> listarVagasOcupadas(){
        return vagaRepository.findByOcupadaIsTrue();
    }

    public List<VagaModel> listarVagasLivres(){
        return vagaRepository.findByOcupadaIsFalse();
    }

    public void  deletarVaga(Long id){
        if (vagaRepository.existsById(id)){
            vagaRepository.deleteById(id);
        }
    }

}
