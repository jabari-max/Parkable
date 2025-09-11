package com.lucas.Parkable.Controllers;

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

    @PostMapping("/registrarEntrada/{placa}/{vagaId}/{tipoVeiculo}")
    public RegistroEstacionamentoModel registarEntrada(@PathVariable String placa, @PathVariable Long vagaId, @PathVariable TipoVeiculo tipoVeiculo){
        return registroEstacionamentoService.registrarEntrada(placa, vagaId, tipoVeiculo);
    }

    @PutMapping("/registrarSaida/{id}")
    public RegistroEstacionamentoModel registarSaida (@PathVariable Long id){
        return registroEstacionamentoService.registrarSaida(id);
    }

    @GetMapping("/listar")
    public List<RegistroEstacionamentoModel> exibirRegistros(){
        return registroEstacionamentoService.exibirRegistros();
    }

    @GetMapping("/listar/tipo/{tipoVeiculo}")
    public List<RegistroEstacionamentoModel> exibirRegistrosTipo(@PathVariable TipoVeiculo tipoVeiculo){
        return registroEstacionamentoService.exibirRegistrosTipo(tipoVeiculo);
    }

    @GetMapping("/listar/placa/{placa}")
    public List<RegistroEstacionamentoModel> exibirRegistrosPlaca(@PathVariable String placa){
        return registroEstacionamentoService.exibirRegistrosPlaca(placa);
    }

    @GetMapping("/listarPresentes")
    public List<RegistroEstacionamentoModel> exibirRegistrosPresentes(){
        return registroEstacionamentoService.exibirRegistrosPresentes();
    }

}
