package br.senai.notasapi.services;

import br.senai.notasapi.entities.UnidadeCurricular;
import br.senai.notasapi.repositories.UnidadeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeCurricularService {

    @Autowired
    private UnidadeCurricularRepository unidadeRepository;

    public List<UnidadeCurricular> listarTodos() {
        return unidadeRepository.findAll();
    }

    public Optional<UnidadeCurricular> buscarPorId(Long id) {
        return unidadeRepository.findById(id);
    }

    public UnidadeCurricular salvar(UnidadeCurricular unidade) {
        return unidadeRepository.save(unidade);
    }

    public UnidadeCurricular atualizar(Long id, UnidadeCurricular atualizada) {
        return unidadeRepository.findById(id)
            .map(uc -> {
                uc.setNomeUc(atualizada.getNomeUc());
                uc.setCurso(atualizada.getCurso());
                return unidadeRepository.save(uc);
            }).orElse(null);
    }

    public void deletar(Long id) {
        unidadeRepository.deleteById(id);
    }
}
