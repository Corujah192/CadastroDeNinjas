package com.treino.cadastroDeNinjas.missoes;

public record ExibirMissaoDTO(
        Long id,
        String nome,
        String rankUP,
        String descricao,
        int qtdPessoas,
        int fracassos,
        boolean statusMissao,
        double recompensa
) {}