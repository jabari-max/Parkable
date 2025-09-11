package com.lucas.Parkable.Controllers;

import com.lucas.Parkable.DTOs.RegistroEstacionamento.RegistroEstacionamentoRequestDTO;
import com.lucas.Parkable.DTOs.RegistroEstacionamento.RegistroEstacionamentoResponseDTO;
import com.lucas.Parkable.Enums.TipoVeiculo;
import com.lucas.Parkable.Models.RegistroEstacionamentoModel;
import com.lucas.Parkable.Service.RegistroEstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estacionamento")
public class RegistroEstacionamentoController {

    @Autowired
    private RegistroEstacionamentoService registroEstacionamentoService;

    @PostMapping("/registrarEntrada")
    public RegistroEstacionamentoResponseDTO registarEntrada(@RequestBody RegistroEstacionamentoRequestDTO registroEstacionamentoRequestDTO){
        return registroEstacionamentoService.registrarEntrada(registroEstacionamentoRequestDTO);
    }

    @PutMapping("/registrarSaida/{id}")
    public RegistroEstacionamentoResponseDTO registrarSaida (@PathVariable Long id){
        return registroEstacionamentoService.registrarSaida(id);
    }

    @GetMapping("/")
    public List<RegistroEstacionamentoResponseDTO> exibirRegistros(){
        return registroEstacionamentoService.exibirRegistros();
    }

    @GetMapping("/tipo/{tipoVeiculo}")
    public List<RegistroEstacionamentoResponseDTO> exibirRegistrosTipo(@PathVariable TipoVeiculo tipoVeiculo){
        return registroEstacionamentoService.exibirRegistrosTipo(tipoVeiculo);
    }

    @GetMapping("/placa/{placa}")
    public List<RegistroEstacionamentoResponseDTO> exibirRegistrosPlaca(@PathVariable String placa){
        return registroEstacionamentoService.exibirRegistrosPlaca(placa);
    }

    @GetMapping("/presentes")
    public List<RegistroEstacionamentoResponseDTO> exibirRegistrosPresentes(){
        return registroEstacionamentoService.exibirRegistrosPresentes();
    }

}
