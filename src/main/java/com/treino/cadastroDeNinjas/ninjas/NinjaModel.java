package com.treino.cadastroDeNinjas.ninjas;

import com.treino.cadastroDeNinjas.missoes.MissoesModel;
import com.treino.cadastroDeNinjas.tecnicas.TecnicasModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cla;

    @Column(name = "rank_ninja")
    private String rankUP;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

    @ManyToMany
    @JoinTable(
            name = "ninja_tecnica",
            joinColumns = @JoinColumn(name = "ninja_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnica_id")
    )
    private List<TecnicasModel> tecnicas;

}
