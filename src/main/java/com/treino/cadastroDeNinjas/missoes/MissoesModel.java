package com.treino.cadastroDeNinjas.missoes;

import com.treino.cadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Column(name = "rank_missao")
    private String rankUP;
    private String descricao;

    private int qtdPessoas;        // Número máximo de ninjas que podem participar
    private boolean statusMissao;  // true = ativa, false = encerrada
    private int fracassos;         // contador de fracassos da missão
    private double recompensa;     // recompensa pela conclusão da missão

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjasMissoes; // ninjas atualmente nessa missão
}