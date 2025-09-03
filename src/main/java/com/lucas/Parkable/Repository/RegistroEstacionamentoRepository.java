package com.lucas.Parkable.Repository;

import com.lucas.Parkable.Models.RegistroEstacionamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroEstacionamentoRepository extends JpaRepository <RegistroEstacionamentoModel, Long> {

}
