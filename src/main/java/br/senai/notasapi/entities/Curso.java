package br.senai.notasapi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurso;

	private String nomeCurso;
	private Integer anoInicio;
	private Integer anoConclusao;

	@OneToMany(mappedBy = "curso")
	private List<Turma> turmas;

	@OneToMany(mappedBy = "curso")
	private List<UnidadeCurricular> unidadesCurriculares;

	public Curso() {
	}

	public Curso(String nomeCurso, Integer anoInicio, Integer anoConclusao) {
		this.nomeCurso = nomeCurso;
		this.anoInicio = anoInicio;
		this.anoConclusao = anoConclusao;
	}

	// Getters e Setters
	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Integer getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(Integer anoInicio) {
		this.anoInicio = anoInicio;
	}

	public Integer getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(Integer anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<UnidadeCurricular> getUnidadesCurriculares() {
		return unidadesCurriculares;
	}

	public void setUnidadesCurriculares(List<UnidadeCurricular> unidadesCurriculares) {
		this.unidadesCurriculares = unidadesCurriculares;
	}
}
