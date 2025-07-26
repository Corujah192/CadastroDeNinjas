package com.treino.cadastroDeNinjas.missoes;

import java.time.LocalDate;

public record ExibirHistoricoMissaoDTO(
        Long id,
        String nomeNinja,
        String nomeMissao,
        boolean sucesso,
        LocalDate dataConclusao
) {}