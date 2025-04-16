package br.senai.notasapi.controllers;

import br.senai.notasapi.entities.UnidadeCurricular;
import br.senai.notasapi.services.UnidadeCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeCurricularController {

    @Autowired
    private UnidadeCurricularService unidadeService;

    @GetMapping
    public List<UnidadeCurricular> listarTodos() {
        return unidadeService.listarTodos();
    }

    @GetMapping("/{id}")
    public UnidadeCurricular buscarPorId(@PathVariable Long id) {
        return unidadeService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public UnidadeCurricular salvar(@RequestBody UnidadeCurricular unidade) {
        return unidadeService.salvar(unidade);
    }

    @PutMapping("/{id}")
    public UnidadeCurricular atualizar(@PathVariable Long id, @RequestBody UnidadeCurricular unidade) {
        return unidadeService.atualizar(id, unidade);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        unidadeService.deletar(id);
    }
}
