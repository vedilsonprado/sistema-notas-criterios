package br.senai.notasapi.services;

import br.senai.notasapi.entities.AlunosCriterios;
import br.senai.notasapi.repositories.AlunosCriteriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunosCriteriosService {

    @Autowired
    private AlunosCriteriosRepository repository;

    public List<AlunosCriterios> listarTodos() {
        return repository.findAll();
    }

    public Optional<AlunosCriterios> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public AlunosCriterios salvar(AlunosCriterios ac) {
        return repository.save(ac);
    }

    public AlunosCriterios atualizar(Long id, AlunosCriterios atualizado) {
        return repository.findById(id)
            .map(ac -> {
                ac.setAluno(atualizado.getAluno());
                ac.setCriterio(atualizado.getCriterio());
                return repository.save(ac);
            }).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
