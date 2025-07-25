package com.treino.cadastroDeNinjas.missoes;

import com.treino.cadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String rank;
    private String descricao;
    private int qtdPessoas;
    private boolean statusMissao;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjasMissoes;
}
