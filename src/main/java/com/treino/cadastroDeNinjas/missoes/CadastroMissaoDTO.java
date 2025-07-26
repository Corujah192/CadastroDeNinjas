package com.treino.cadastroDeNinjas.missoes;

public record CadastroMissaoDTO(
        String nome,
        String rankUP,
        String descricao,
        int qtdPessoas,
        double recompensa
) {}
