package br.senai.notasapi.services;

import br.senai.notasapi.entities.Turma;
import br.senai.notasapi.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> listarTodos() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> buscarPorId(Long id) {
        return turmaRepository.findById(id);
    }

    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma atualizar(Long id, Turma turmaAtualizada) {
        return turmaRepository.findById(id)
            .map(turma -> {
                turma.setNomeTurma(turmaAtualizada.getNomeTurma());
                turma.setCurso(turmaAtualizada.getCurso());
                return turmaRepository.save(turma);
            }).orElse(null);
    }

    public void deletar(Long id) {
        turmaRepository.deleteById(id);
    }
}
