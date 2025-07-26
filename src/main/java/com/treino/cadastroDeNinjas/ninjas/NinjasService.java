package com.treino.cadastroDeNinjas.ninjas;

import com.treino.cadastroDeNinjas.missoes.HistoricoMissaoModel;
import com.treino.cadastroDeNinjas.missoes.HistoricoMissaoRepository;
import com.treino.cadastroDeNinjas.missoes.MissoesModel;
import com.treino.cadastroDeNinjas.missoes.MissoesRepository;
import com.treino.cadastroDeNinjas.tecnicas.TecnicasModel;
import com.treino.cadastroDeNinjas.tecnicas.TecnicasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjasService {

    private final NinjasRepository repository;
    private final HistoricoMissaoRepository historicoRepository;
    private final MissoesRepository missoesRepository;
    private final TecnicasRepository tecnicasRepository;

    public NinjasService(NinjasRepository repository, HistoricoMissaoRepository historicoRepository, MissoesRepository missoesRepository, TecnicasRepository tecnicasRepository) {
        this.repository = repository;
        this.historicoRepository = historicoRepository;
        this.missoesRepository = missoesRepository;
        this.tecnicasRepository = tecnicasRepository;
    }

    public void cadastraNinjas(NinjaModel ninja) {
        repository.saveAndFlush(ninja);
    }

    public NinjaDTO buscaNinja(String nome, String cla) {
        NinjaModel ninja = repository.findByNomeAndCla(nome, cla)
                .orElseThrow(() -> new RuntimeException("Ninja com esse nome e clã não encontrado"));
        return new NinjaDTO(ninja);
    }

    public NinjaDTO buscaNinjaPorId(Long id) {
        NinjaModel ninja = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja Com Esse Id não Encontrado"));
        return new NinjaDTO(ninja);
    }

    public void deletaNinjaPorId(Long id) {
        repository.deleteById(id);
    }

    public void atualizarUsuarioPorId(Long id, NinjaAtualizacaoDTO dto) {
        NinjaModel ninja = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado"));

        if (dto.nome() != null) ninja.setNome(dto.nome());
        if (dto.cla() != null) ninja.setCla(dto.cla());
        if (dto.rankUP() != null) ninja.setRankUP(dto.rankUP());

        if (dto.missaoId() != null) {
            MissoesModel missao = missoesRepository.findById(dto.missaoId())
                    .orElseThrow(() -> new RuntimeException("Missão não encontrada"));
            ninja.setMissoes(missao);
        }

        if (dto.tecnicasIds() != null) {
            List<TecnicasModel> tecnicas = tecnicasRepository.findAllById(dto.tecnicasIds());
            ninja.setTecnicas(tecnicas);
        }

        repository.save(ninja);}

    public NinjaComHistoricoDTO getNinjaComHistorico(Long ninjaId) {
        NinjaModel ninja = repository.findById(ninjaId)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado"));

        List<HistoricoMissaoModel> historico = historicoRepository.findByNinjaId(ninjaId);

        return new NinjaComHistoricoDTO(ninja, historico);
    }
}
