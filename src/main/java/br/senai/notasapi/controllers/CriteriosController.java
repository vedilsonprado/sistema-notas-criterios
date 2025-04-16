package br.senai.notasapi.controllers;

import br.senai.notasapi.entities.Criterios;
import br.senai.notasapi.services.CriteriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criterios")
public class CriteriosController {

    @Autowired
    private CriteriosService criteriosService;

    @GetMapping
    public List<Criterios> listarTodos() {
        return criteriosService.listarTodos();
    }

    @GetMapping("/{id}")
    public Criterios buscarPorId(@PathVariable Long id) {
        return criteriosService.buscarPorId(id).orElse(null);
    }

    @PostMapping
    public Criterios salvar(@RequestBody Criterios criterio) {
        return criteriosService.salvar(criterio);
    }

    @PutMapping("/{id}")
    public Criterios atualizar(@PathVariable Long id, @RequestBody Criterios criterio) {
        return criteriosService.atualizar(id, criterio);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        criteriosService.deletar(id);
    }
}
