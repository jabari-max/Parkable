package com.lucas.Parkable.Repository;

import com.lucas.Parkable.Enums.TipoVeiculo;
import com.lucas.Parkable.Models.RegistroEstacionamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroEstacionamentoRepository extends JpaRepository <RegistroEstacionamentoModel, Long> {

    List<RegistroEstacionamentoModel> findByPlaca(String placa);

    List<RegistroEstacionamentoModel> findByTipoVeiculo(TipoVeiculo tipoVeiculo);
}
