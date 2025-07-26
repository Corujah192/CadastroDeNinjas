package com.treino.cadastroDeNinjas.ninjas;

import com.treino.cadastroDeNinjas.missoes.HistoricoMissaoModel;
import com.treino.cadastroDeNinjas.ninjas.NinjaModel;

import java.util.List;

public record NinjaComHistoricoDTO(
        Long id,
        String nome,
        String cla,
        String rankUP,
        List<HistoricoMissaoDTO> historico
) {
    public NinjaComHistoricoDTO(NinjaModel ninja, List<HistoricoMissaoModel> historico) {
        this(
                ninja.getId(),
                ninja.getNome(),
                ninja.getCla(),
                ninja.getRankUP(),
                historico.stream()
                        .map(HistoricoMissaoDTO::new)
                        .toList()
        );
    }

    public record HistoricoMissaoDTO(
            Long id,
            String nomeMissao,
            boolean sucesso
    ) {
        public HistoricoMissaoDTO(HistoricoMissaoModel historico) {
            this(
                    historico.getId(),
                    historico.getMissao().getNome(),
                    historico.isSucesso()
            );
        }
    }
}
