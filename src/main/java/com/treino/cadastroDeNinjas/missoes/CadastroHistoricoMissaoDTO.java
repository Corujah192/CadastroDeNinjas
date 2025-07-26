package com.treino.cadastroDeNinjas.missoes;

import java.time.LocalDate;

public record CadastroHistoricoMissaoDTO(
        Long ninjaId,
        Long missaoId,
        boolean sucesso,
        LocalDate dataConclusao
) {}
