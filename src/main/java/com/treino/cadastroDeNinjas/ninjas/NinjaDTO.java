package com.treino.cadastroDeNinjas.ninjas;

import com.treino.cadastroDeNinjas.ninjas.NinjaModel;
import com.treino.cadastroDeNinjas.tecnicas.TecnicasModel;

import java.util.List;
import java.util.stream.Collectors;

public record NinjaDTO(
        Long id,
        String nome,
        String cla,
        String rankUP,
        List<String> tecnicas
) {
    public NinjaDTO(NinjaModel ninja) {
        this(
                ninja.getId(),
                ninja.getNome(),
                ninja.getCla(),
                ninja.getRankUP(),
                ninja.getTecnicas() == null ? List.of() :
                        ninja.getTecnicas()
                                .stream()
                                .map(TecnicasModel::getNome)
                                .collect(Collectors.toList())
        );
    }
}