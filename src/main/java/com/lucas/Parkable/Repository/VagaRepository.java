package com.lucas.Parkable.Repository;

import com.lucas.Parkable.Models.VagaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VagaRepository extends JpaRepository <VagaModel, Long> {

    List<VagaModel> findByOcupadaIsTrue();

    List<VagaModel> findByOcupadaIsFalse();
}
