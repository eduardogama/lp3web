package entidades;


public class Candidato {
	
	private String nome;
	private String partido;
	private String idade;
	
	public Candidato(String nome, String idade, String partido, Debate dbte){
		this.nome = nome;
		this.idade = idade;
		this.partido = partido;
		dbte.addCandidato(this);		
	}

	public Candidato() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	
}
