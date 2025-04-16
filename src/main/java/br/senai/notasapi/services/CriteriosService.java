package br.senai.notasapi.services;

import br.senai.notasapi.entities.Criterios;
import br.senai.notasapi.repositories.CriteriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriteriosService {

    @Autowired
    private CriteriosRepository criteriosRepository;

    public List<Criterios> listarTodos() {
        return criteriosRepository.findAll();
    }

    public Optional<Criterios> buscarPorId(Long id) {
        return criteriosRepository.findById(id);
    }

    public Criterios salvar(Criterios criterio) {
        return criteriosRepository.save(criterio);
    }

    public Criterios atualizar(Long id, Criterios atualizado) {
        return criteriosRepository.findById(id)
            .map(criterio -> {
                criterio.setResultado(atualizado.getResultado());
                criterio.setObtencao(atualizado.getObtencao());
                criterio.setMateria(atualizado.getMateria());
                return criteriosRepository.save(criterio);
            }).orElse(null);
    }

    public void deletar(Long id) {
        criteriosRepository.deleteById(id);
    }
}
