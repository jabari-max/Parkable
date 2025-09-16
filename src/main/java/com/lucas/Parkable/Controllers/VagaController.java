package com.lucas.Parkable.Controllers;

import com.lucas.Parkable.DTOs.Vaga.VagaRequestDTO;
import com.lucas.Parkable.DTOs.Vaga.VagaResponseDTO;
import com.lucas.Parkable.Service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagasService vagasService;

    @PostMapping("/adicionar")
    public ResponseEntity<VagaResponseDTO> adicionarVaga(@RequestBody VagaRequestDTO vagaRequestDTO) {
        VagaResponseDTO vagaAdicionada = vagasService.adicionarVaga(vagaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vagaAdicionada);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<List<VagaResponseDTO>> listarTodasVagas() {
        List<VagaResponseDTO> vagasDTO = vagasService.listarTodasVagas();
        return ResponseEntity.ok(vagasDTO);
    }

    @GetMapping("/ocupadas")
    public ResponseEntity<List<VagaResponseDTO>> listarVagasOcupadas() {
        List<VagaResponseDTO> vagasEncontradas = vagasService.listarVagasOcupadas();
        return ResponseEntity.ok(vagasEncontradas);
    }

    @GetMapping("/livres")
    public ResponseEntity<List<VagaResponseDTO>> listarVagasLivres() {
        List<VagaResponseDTO> vagasEncontradas = vagasService.listarVagasLivres();
        return ResponseEntity.ok(vagasEncontradas);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarVaga(@PathVariable Long id) {
        boolean deletado = vagasService.deletarVaga(id);

        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A vaga de ID #" + id + " não foi encontrada!");
        }
    }
}

