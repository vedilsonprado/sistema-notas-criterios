package br.senai.notasapi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Criterios")
public class Criterios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCriterio;

	private String resultado;
	private String obtencao;

	@ManyToOne
	@JoinColumn(name = "materia_id")
	private UnidadeCurricular materia;

	@OneToMany(mappedBy = "criterio")
	private List<AlunosCriterios> alunos;

	public Criterios() {
	}

	public Criterios(String resultado, String obtencao, UnidadeCurricular materia) {
		this.resultado = resultado;
		this.obtencao = obtencao;
		this.materia = materia;
	}

	// Getters e Setters
	public Long getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(Long idCriterio) {
		this.idCriterio = idCriterio;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getObtencao() {
		return obtencao;
	}

	public void setObtencao(String obtencao) {
		this.obtencao = obtencao;
	}

	public UnidadeCurricular getMateria() {
		return materia;
	}

	public void setMateria(UnidadeCurricular materia) {
		this.materia = materia;
	}

	public List<AlunosCriterios> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunosCriterios> alunos) {
		this.alunos = alunos;
	}
}
