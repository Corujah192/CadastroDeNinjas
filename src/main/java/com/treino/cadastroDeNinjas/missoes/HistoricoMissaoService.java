package com.treino.cadastroDeNinjas.missoes;

import com.treino.cadastroDeNinjas.ninjas.NinjaModel;
import com.treino.cadastroDeNinjas.ninjas.NinjasRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoMissaoService {

    private final HistoricoMissaoRepository historicoRepository;
    private final MissoesRepository missoesRepository;
    private final NinjasRepository ninjasRepository;

    public HistoricoMissaoService(
            HistoricoMissaoRepository historicoRepository,
            MissoesRepository missoesRepository,
            NinjasRepository ninjasRepository
    ) {
        this.historicoRepository = historicoRepository;
        this.missoesRepository = missoesRepository;
        this.ninjasRepository = ninjasRepository;
    }

    @Transactional
    public void registrarConclusao(CadastroHistoricoMissaoDTO dto) {
        var ninja = ninjasRepository.findById(dto.ninjaId())
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado"));

        var missao = missoesRepository.findById(dto.missaoId())
                .orElseThrow(() -> new RuntimeException("Missão não encontrada"));

        // Atualiza o contador de fracassos, se necessário
        if (!dto.sucesso()) {
            missao.setFracassos(missao.getFracassos() + 1);
        }

        // Cria o histórico
        var historico = HistoricoMissaoModel.builder()
                .ninja(ninja)
                .missao(missao)
                .sucesso(dto.sucesso())
                .dataConclusao(dto.dataConclusao())
                .build();

        historicoRepository.save(historico);
    }

    public List<ExibirHistoricoMissaoDTO> listarPorNinja(Long ninjaId) {
        var historicos = historicoRepository.findByNinjaId(ninjaId);

        return historicos.stream()
                .map(h -> new ExibirHistoricoMissaoDTO(
                        h.getId(),
                        h.getNinja().getNome(),
                        h.getMissao().getNome(),
                        h.isSucesso(),
                        h.getDataConclusao()
                )).toList();
    }
}
