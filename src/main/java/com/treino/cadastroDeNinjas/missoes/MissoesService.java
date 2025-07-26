package com.treino.cadastroDeNinjas.missoes;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private final MissoesRepository repository;

    public MissoesService(MissoesRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void criaMissao(CadastroMissaoDTO dto) {
        MissoesModel nova = MissoesModel.builder()
                .nome(dto.nome())
                .rankUP(dto.rankUP())
                .descricao(dto.descricao())
                .qtdPessoas(dto.qtdPessoas())
                .statusMissao(true)
                .fracassos(0)
                .recompensa(dto.recompensa())
                .build();

        repository.save(nova);
    }

    public List<ExibirMissaoDTO> listarMissoes() {
        return repository.findAll().stream()
                .map(m -> new ExibirMissaoDTO(
                        m.getId(),
                        m.getNome(),
                        m.getRankUP(),
                        m.getDescricao(),
                        m.getQtdPessoas(),
                        m.getFracassos(),
                        m.isStatusMissao(),
                        m.getRecompensa()
                )).toList();
    }
}

