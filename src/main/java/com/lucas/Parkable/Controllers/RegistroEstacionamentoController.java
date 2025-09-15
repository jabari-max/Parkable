package com.lucas.Parkable.Controllers;

import com.lucas.Parkable.DTOs.RegistroEstacionamento.RegistroEstacionamentoRequestDTO;
import com.lucas.Parkable.DTOs.RegistroEstacionamento.RegistroEstacionamentoResponseDTO;
import com.lucas.Parkable.Enums.TipoVeiculo;
import com.lucas.Parkable.Service.RegistroEstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estacionamento")
public class RegistroEstacionamentoController {

    @Autowired
    private RegistroEstacionamentoService registroEstacionamentoService;

    @PostMapping("/registrarEntrada")
    public ResponseEntity<RegistroEstacionamentoResponseDTO> registarEntrada(@RequestBody RegistroEstacionamentoRequestDTO registroEstacionamentoRequestDTO){
        RegistroEstacionamentoResponseDTO veiculoAdicionado = registroEstacionamentoService.registrarEntrada(registroEstacionamentoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(veiculoAdicionado);
    }

    @PutMapping("/registrarSaida/{id}")
    public ResponseEntity<?> registrarSaida (@PathVariable Long id){
        RegistroEstacionamentoResponseDTO registroComSaida = registroEstacionamentoService.registrarSaida(id);

        if (registroComSaida != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(registroComSaida);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado nenhum veículo com ID #" + id + ".");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<RegistroEstacionamentoResponseDTO>> exibirRegistros(){
        List<RegistroEstacionamentoResponseDTO> registrosEncontrados = registroEstacionamentoService.exibirRegistros();
        return ResponseEntity.ok(registrosEncontrados);
    }

    @GetMapping("/tipo/{tipoVeiculo}")
    public ResponseEntity<List<RegistroEstacionamentoResponseDTO>> exibirRegistrosTipo(@PathVariable TipoVeiculo tipoVeiculo){
        List<RegistroEstacionamentoResponseDTO> veiculosEncontrados = registroEstacionamentoService.exibirRegistrosTipo(tipoVeiculo);
        return ResponseEntity.ok(veiculosEncontrados);
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<List<RegistroEstacionamentoResponseDTO>> exibirRegistrosPlaca(@PathVariable String placa){
        List<RegistroEstacionamentoResponseDTO> veiculosEncontrados = registroEstacionamentoService.exibirRegistrosPlaca(placa);
        return ResponseEntity.ok(veiculosEncontrados);
    }

    @GetMapping("/presentes")
    public ResponseEntity<List<RegistroEstacionamentoResponseDTO>> exibirRegistrosPresentes(){
        List<RegistroEstacionamentoResponseDTO> veiculosEncontrados = registroEstacionamentoService.exibirRegistrosPresentes();
        return ResponseEntity.ok(veiculosEncontrados);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarRegistro(@PathVariable Long id){
        boolean registroDeletado = registroEstacionamentoService.deletarRegistro(id);

        if (registroDeletado){
            return ResponseEntity.noContent().build();
        } return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O registro de ID #" + id + " não foi encontrado!");
    }

}
