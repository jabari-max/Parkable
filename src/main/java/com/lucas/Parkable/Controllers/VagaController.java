package com.lucas.Parkable.Controllers;

import com.lucas.Parkable.Models.VagaModel;
import com.lucas.Parkable.Service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagasService vagasService;

    @PostMapping("/adicionar/{codigoVaga}")
    public VagaModel adicionarVaga (@PathVariable String codigoVaga){
        return vagasService.adicionarVaga(codigoVaga);
    }

    @GetMapping("/listar")
    public List<VagaModel> listarTodasVagas(){
        return vagasService.listarTodasVagas();
    }

    @GetMapping("/listarOcupadas")
    public List<VagaModel> listarVagasOcupadas(){
        return vagasService.listarVagasOcupadas();
    }

    @GetMapping ("/listarLivres")
    public List<VagaModel> listarVagasLivres(){
        return vagasService.listarVagasLivres();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarVaga(@PathVariable Long id){
        vagasService.deletarVaga(id);
    }
}

