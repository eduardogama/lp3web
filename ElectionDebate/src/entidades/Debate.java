package entidades;

import java.util.List;
import java.util.Vector;

public class Debate {
	
	private String nome;
	private List<Candidato> candidatos;
	
	public Debate(String nome){
		this.nome = nome;
		this.candidatos = new Vector<Candidato>();
	}
	
	public void addCandidato(Candidato cddto){
		this.candidatos.add(cddto);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
}
