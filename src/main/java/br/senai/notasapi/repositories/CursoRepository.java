package br.senai.notasapi.repositories;

import br.senai.notasapi.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
