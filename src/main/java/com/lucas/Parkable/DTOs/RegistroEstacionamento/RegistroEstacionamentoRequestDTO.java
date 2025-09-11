package com.lucas.Parkable.DTOs.RegistroEstacionamento;

import com.lucas.Parkable.Enums.TipoVeiculo;

public record RegistroEstacionamentoRequestDTO(
        String placa,
        Long vagaId,
        TipoVeiculo tipoVeiculo) {

}
