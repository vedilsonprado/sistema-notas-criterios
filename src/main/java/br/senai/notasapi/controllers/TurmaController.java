package br.senai.notasapi.controllers;

import br.senai.notasapi.entities.Turma;
import br.senai.notasapi.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<Turma> listarTodos() {
        return turmaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Turma buscarPorId(@PathVariable Long id) {
        return turmaService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Turma salvar(@RequestBody Turma turma) {
        return turmaService.salvar(turma);
    }

    @PutMapping("/{id}")
    public Turma atualizar(@PathVariable Long id, @RequestBody Turma turma) {
        return turmaService.atualizar(id, turma);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        turmaService.deletar(id);
    }
}
