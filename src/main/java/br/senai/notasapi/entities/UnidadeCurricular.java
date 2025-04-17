package br.senai.notasapi.entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "UnidadeCurricular")
public class UnidadeCurricular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUnidadeCurricular;

	private String nomeUc;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@OneToMany(mappedBy = "materia")
	@JsonManagedReference
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
