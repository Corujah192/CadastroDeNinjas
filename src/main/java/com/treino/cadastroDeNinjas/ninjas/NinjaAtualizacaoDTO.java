package com.treino.cadastroDeNinjas.ninjas;

import java.util.List;

public record NinjaAtualizacaoDTO(
        String nome,
        String cla,
        String rankUP,
        List<Long> tecnicasIds,  // você pode usar apenas os IDs das técnicas
        Long missaoId           // ID da missão atual atribuída
) {}