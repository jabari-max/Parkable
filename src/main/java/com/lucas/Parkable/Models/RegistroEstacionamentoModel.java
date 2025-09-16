package com.lucas.Parkable.Models;

import com.lucas.Parkable.Enums.TipoVeiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "tb_estacionamento")
public class RegistroEstacionamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false)
    private String placa;

    @Column (nullable = false)
    private LocalDateTime horarioEntrada;

    private LocalDateTime horarioSaida;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "vaga_id", nullable = false)
    private VagaModel vaga;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVeiculo tipoVeiculo;

}
