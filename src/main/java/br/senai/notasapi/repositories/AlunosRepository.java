package br.senai.notasapi.repositories;

import br.senai.notasapi.entities.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {
}
