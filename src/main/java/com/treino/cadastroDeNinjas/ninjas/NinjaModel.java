package com.treino.cadastroDeNinjas.ninjas;

import com.treino.cadastroDeNinjas.missoes.MissoesModel;
import com.treino.cadastroDeNinjas.tecnicas.TecnicasModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_cadastro")
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

    public NinjaModel () {}

    public NinjaModel(String rank, String cla, String nome) {
        this.cla = cla;
        this.rank = rank;
        this.nome = nome;
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

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public MissoesModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }

    public List<MissoesModel> getMissoesConcluidas() {
        return missoesConcluidas;
    }

    public void setMissoesConcluidas(List<MissoesModel> missoesConcluidas) {
        this.missoesConcluidas = missoesConcluidas;
    }

    public List<TecnicasModel> getTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(List<TecnicasModel> tecnicas) {
        this.tecnicas = tecnicas;
    }
}
