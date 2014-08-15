package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Debate {
	@Id
	@GeneratedValue
	private long idDebate;

	private String nome;
	private String descricao;
	private String data;
	@OneToMany
	private List<Candidato> candidatos;
	@OneToMany
	private List<Pergunta> perguntas;

	public Debate(String nome) {
		this.nome = nome;
		this.candidatos = new ArrayList<Candidato>();
		this.perguntas = new ArrayList<Pergunta>();
	}

	public Debate() {
		this.candidatos = new ArrayList<Candidato>();
		this.perguntas = new ArrayList<Pergunta>();
	}

	public void addCandidato(Candidato cddto) {
		this.candidatos.add(cddto);
	}

	public long getIdDebate() {
		return idDebate;
	}

	public void setIdDebate(long idDebate) {
		this.idDebate = idDebate;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

}
