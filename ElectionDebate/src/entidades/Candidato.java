package entidades;


public class Candidato {
	
	private String nome;
	
	public Candidato(String nome, Debate dbte){
		this.nome = nome;
		dbte.addCandidato(this);		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
