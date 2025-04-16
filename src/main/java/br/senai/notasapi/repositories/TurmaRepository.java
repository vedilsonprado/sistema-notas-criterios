package br.senai.notasapi.repositories;

import br.senai.notasapi.entities.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
