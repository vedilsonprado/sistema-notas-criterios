package br.senai.notasapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.notasapi.entities.AlunosCriterios;
import br.senai.notasapi.services.AlunosCriteriosService;

@RestController
@RequestMapping("/alunos-criterios")
public class AlunosCriteriosController {

    @Autowired
    private AlunosCriteriosService alunosCriteriosService;

    @GetMapping
    public List<AlunosCriterios> listarTodos() {
        return alunosCriteriosService.listarTodos();
    }

    @GetMapping("/{id}")
    public AlunosCriterios buscarPorId(@PathVariable Long id) {
        return alunosCriteriosService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public AlunosCriterios salvar(@RequestBody AlunosCriterios ac) {
        return alunosCriteriosService.salvar(ac);
    }

    @PutMapping("/{id}")
    public AlunosCriterios atualizar(@PathVariable Long id, @RequestBody AlunosCriterios ac) {
        return alunosCriteriosService.atualizar(id, ac);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        alunosCriteriosService.deletar(id);
    }
}
