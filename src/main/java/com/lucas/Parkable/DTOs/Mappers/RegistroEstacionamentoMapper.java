package com.lucas.Parkable.DTOs.Mappers;

import com.lucas.Parkable.DTOs.RegistroEstacionamento.RegistroEstacionamentoResponseDTO;
import com.lucas.Parkable.Models.RegistroEstacionamentoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegistroEstacionamentoMapper {

    @Mapping(source = "vaga.codigoVaga", target = "codigoVaga")
    RegistroEstacionamentoResponseDTO map (RegistroEstacionamentoModel registroEstacionamentoModel);
    RegistroEstacionamentoModel map (RegistroEstacionamentoResponseDTO registroEstacionamentoResponseDTO);
}
