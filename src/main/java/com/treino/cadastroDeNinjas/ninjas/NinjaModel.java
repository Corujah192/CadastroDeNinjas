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
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cla;

    private String rank;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;

    private List<MissoesModel> missoesConcluidas;
    private List<TecnicasModel> tecnicas;

}
