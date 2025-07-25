package com.treino.cadastroDeNinjas.missoes;

import com.treino.cadastroDeNinjas.ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
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

    public MissoesModel() {}

    public MissoesModel(String nome, String rank, String descricao, int qtdPessoas) {
        this.nome = nome;
        this.rank = rank;
        this.descricao = descricao;
        this.qtdPessoas = qtdPessoas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public boolean isStatusMissao() {
        return statusMissao;
    }

    public void setStatusMissao(boolean statusMissao) {
        this.statusMissao = statusMissao;
    }

    public List<NinjaModel> getNinjasMissoes() {
        return ninjasMissoes;
    }

    public void setNinjasMissoes(List<NinjaModel> ninjasMissoes) {
        this.ninjasMissoes = ninjasMissoes;
    }
}
