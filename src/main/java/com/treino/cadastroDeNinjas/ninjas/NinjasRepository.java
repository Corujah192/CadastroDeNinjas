package com.treino.cadastroDeNinjas.ninjas;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NinjasRepository extends JpaRepository<NinjaModel, Long> {

    Optional<NinjaModel> findByNomeAndCla(String nome, String cla);
    Optional<NinjaModel> findById(Long id);

    @Transactional
    void deleteById(Long id);
}
