package br.senai.notasapi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "UnidadeCurricular")
public class UnidadeCurricular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUnidadeCurricular;

	private String nomeUc;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@OneToMany(mappedBy = "materia")
	private List<Criterios> criterios;

	public UnidadeCurricular() {
	}

	public UnidadeCurricular(String nomeUc, Curso curso) {
		this.nomeUc = nomeUc;
		this.curso = curso;
	}

	// Getters e Setters
	public Long getIdUnidadeCurricular() {
		return idUnidadeCurricular;
	}

	public void setIdUnidadeCurricular(Long idUnidadeCurricular) {
		this.idUnidadeCurricular = idUnidadeCurricular;
	}

	public String getNomeUc() {
		return nomeUc;
	}

	public void setNomeUc(String nomeUc) {
		this.nomeUc = nomeUc;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Criterios> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<Criterios> criterios) {
		this.criterios = criterios;
	}
}
