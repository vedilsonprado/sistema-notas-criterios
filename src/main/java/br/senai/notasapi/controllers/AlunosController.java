package br.senai.notasapi.controllers;

import br.senai.notasapi.entities.Alunos;
import br.senai.notasapi.services.AlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private AlunosService alunosService;

    @GetMapping
    public List<Alunos> listarTodos() {
        return alunosService.listarTodos();
    }

    @GetMapping("/{id}")
    public Alunos buscarPorId(@PathVariable Long id) {
        return alunosService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Alunos salvar(@RequestBody Alunos aluno) {
        return alunosService.salvar(aluno);
    }

    @PutMapping("/{id}")
    public Alunos atualizar(@PathVariable Long id, @RequestBody Alunos aluno) {
        return alunosService.atualizar(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        alunosService.deletar(id);
    }
}
