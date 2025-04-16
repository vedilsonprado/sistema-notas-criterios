package br.senai.notasapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "AlunosCriterios")
public class AlunosCriterios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlunoCriterio;

	@ManyToOne
	@JoinColumn(name = "idAluno")
	private Alunos aluno;

	@ManyToOne
	@JoinColumn(name = "idCriterio")
	private Criterios criterio;

	public AlunosCriterios() {
	}

	public AlunosCriterios(Alunos aluno, Criterios criterio) {
		this.aluno = aluno;
		this.criterio = criterio;
	}

	// Getters e Setters
	public Long getIdAlunoCriterio() {
		return idAlunoCriterio;
	}

	public void setIdAlunoCriterio(Long idAlunoCriterio) {
		this.idAlunoCriterio = idAlunoCriterio;
	}

	public Alunos getAluno() {
		return aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}

	public Criterios getCriterio() {
		return criterio;
	}

	public void setCriterio(Criterios criterio) {
		this.criterio = criterio;
	}
}
