package br.senai.notasapi.entities;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Alunos")
public class Alunos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;

	private String nomeAluno;
	private String emailAluno;
	private String imagemAluno;
	
	@Lob
	@Column(name = "foto")
	private byte[] foto;

	@ManyToOne
	@JoinColumn(name = "turma")
	@JsonBackReference
	private Turma turma;

	@OneToMany(mappedBy = "aluno")
	@JsonManagedReference
	private List<AlunosCriterios> criterios;

	public Alunos() {
	}

	public Alunos(String nomeAluno, String emailAluno, String imagemAluno, Turma turma) {
		this.nomeAluno = nomeAluno;
		this.emailAluno = emailAluno;
		this.imagemAluno = imagemAluno;
		this.turma = turma;
	}

	// Getters e Setters
	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public String getImagemAluno() {
		return imagemAluno;
	}

	public void setImagemAluno(String imagemAluno) {
		this.imagemAluno = imagemAluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<AlunosCriterios> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<AlunosCriterios> criterios) {
		this.criterios = criterios;
	}
}
