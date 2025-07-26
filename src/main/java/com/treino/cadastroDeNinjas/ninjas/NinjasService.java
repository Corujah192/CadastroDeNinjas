package com.treino.cadastroDeNinjas.ninjas;

import org.springframework.stereotype.Service;

@Service
public class NinjasService {

    private final NinjasRepository repository;

    public NinjasService(NinjasRepository repository) {
        this.repository = repository;
    }
    
    public void cadastraNinjas (NinjaModel ninja) {
        repository.saveAndFlush(ninja);
    }

    public NinjaModel buscaNinja(String nome, String cla) {
        return repository.findByNomeAndCla(nome, cla)
                .orElseThrow(() -> new RuntimeException("Ninja com esse nome e clã não encontrado"));
    }

    public NinjaModel buscaNinjaPorId (Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja Com Esse Id não Encontrado"));
    }

    public void deletaNinjaPorId(Long id) {
        repository.deleteById(id);
    }

    public void atualizarUsuarioPorId (Long id, NinjaModel ninja) {
   NinjaModel ninjaEntity = repository.findById(id).orElseThrow(() ->
        new RuntimeException("Ninja não encontrado"));
   NinjaModel ninjaAtualizado = NinjaModel.builder()
           .nome(NinjaModel.getNome() != null ? ninja.getNome() : ninjaEntity.getNome())
           .rank(NinjaModel.getRank() != null ? ninja.getRank() : ninjaEntity.getRank())
           .cla(NinjaModel.getCla() != null ? ninja.getCla() : ninjaEntity.getCla())
           .id(ninjaEntity.getId());
    }
}
