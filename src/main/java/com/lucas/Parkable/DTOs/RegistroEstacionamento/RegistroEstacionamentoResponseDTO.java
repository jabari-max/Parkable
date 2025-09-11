package com.lucas.Parkable.DTOs.RegistroEstacionamento;

import com.lucas.Parkable.Enums.TipoVeiculo;
import java.time.LocalDateTime;

public record RegistroEstacionamentoResponseDTO(
        Long id,
        String placa,
        TipoVeiculo tipoVeiculo,
        String codigoVaga,
        LocalDateTime horarioEntrada,
        LocalDateTime horarioSaida,
        double valor
) {
}
