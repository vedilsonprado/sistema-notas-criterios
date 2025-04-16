package br.senai.notasapi.services;

import br.senai.notasapi.entities.Curso;
import br.senai.notasapi.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso atualizar(Long id, Curso cursoAtualizado) {
        return cursoRepository.findById(id)
            .map(curso -> {
                curso.setNomeCurso(cursoAtualizado.getNomeCurso());
                curso.setAnoInicio(cursoAtualizado.getAnoInicio());
                curso.setAnoConclusao(cursoAtualizado.getAnoConclusao());
                return cursoRepository.save(curso);
            }).orElse(null);
    }

    public void deletar(Long id) {
        cursoRepository.deleteById(id);
    }
}
