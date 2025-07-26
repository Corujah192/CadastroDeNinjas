package com.treino.cadastroDeNinjas.missoes;

import com.treino.cadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_historico_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoMissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ninja_id")
    private NinjaModel ninja;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissoesModel missao;

    private boolean sucesso;
    private LocalDate dataConclusao;
}
