package br.senai.notasapi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Turma")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTurma;

	private String nomeTurma;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@OneToMany(mappedBy = "turma")
	private List<Alunos> alunos;

	public Turma() {
	}

	public Turma(String nomeTurma, Curso curso) {
		this.nomeTurma = nomeTurma;
		this.curso = curso;
	}

	// Getters e Setters
	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Alunos> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Alunos> alunos) {
		this.alunos = alunos;
	}
}
