package com.treino.cadastroDeNinjas.missoes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoMissaoRepository extends JpaRepository<HistoricoMissaoModel, Long> {
    List<HistoricoMissaoModel> findByNinjaId(Long ninjaId);
}
