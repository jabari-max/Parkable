package com.lucas.Parkable.DTOs.Mappers;

import com.lucas.Parkable.DTOs.VagaResponseDTO;
import com.lucas.Parkable.Models.VagaModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VagaMapper {
    VagaResponseDTO map(VagaModel vagaModel);
    VagaModel map(VagaResponseDTO vagaResponseDTO);

}
