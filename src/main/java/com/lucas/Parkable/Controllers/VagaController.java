package com.lucas.Parkable.Controllers;

import com.lucas.Parkable.DTOs.Vaga.VagaRequestDTO;
import com.lucas.Parkable.DTOs.Vaga.VagaResponseDTO;
import com.lucas.Parkable.Service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagasService vagasService;

    @PostMapping("/adicionar")
    public VagaResponseDTO adicionarVaga (@RequestBody VagaRequestDTO codigoVaga){
        return vagasService.adicionarVaga(codigoVaga);
    }

    @GetMapping("/listar")
    public List<VagaResponseDTO> listarTodasVagas(){
        return vagasService.listarTodasVagas();
    }

    @GetMapping("/listarOcupadas")
    public List<VagaResponseDTO> listarVagasOcupadas(){
        return vagasService.listarVagasOcupadas();
    }

    @GetMapping ("/listarLivres")
    public List<VagaResponseDTO> listarVagasLivres(){
        return vagasService.listarVagasLivres();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarVaga(@PathVariable Long id){
        vagasService.deletarVaga(id);
    }
}

