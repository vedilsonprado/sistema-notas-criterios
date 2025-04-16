package br.senai.notasapi.services;

import br.senai.notasapi.entities.Alunos;
import br.senai.notasapi.repositories.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    @Autowired
    private AlunosRepository alunosRepository;

    public List<Alunos> listarTodos() {
        return alunosRepository.findAll();
    }

    public Optional<Alunos> buscarPorId(Long id) {
        return alunosRepository.findById(id);
    }

    public Alunos salvar(Alunos aluno) {
        return alunosRepository.save(aluno);
    }

    public Alunos atualizar(Long id, Alunos atualizado) {
        return alunosRepository.findById(id)
            .map(aluno -> {
                aluno.setNomeAluno(atualizado.getNomeAluno());
                aluno.setEmailAluno(atualizado.getEmailAluno());
                aluno.setImagemAluno(atualizado.getImagemAluno());
                aluno.setTurma(atualizado.getTurma());
                return alunosRepository.save(aluno);
            }).orElse(null);
    }

    public void deletar(Long id) {
        alunosRepository.deleteById(id);
    }
}
