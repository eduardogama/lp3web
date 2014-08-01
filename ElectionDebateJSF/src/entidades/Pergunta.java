package entidades;

import java.util.HashMap;

public class Pergunta {
	
	private String prgta;
	private HashMap<String, Integer> candidatos = new HashMap<String, Integer>();
	
	public String getPrgta() {
		return prgta;
	}
	public void setPrgta(String prgta) {
		this.prgta = prgta;
	}
	public HashMap<String, Integer> getCandidatos() {
		return candidatos;
	}
	public void setCandidatos(HashMap<String, Integer> candidatos) {
		this.candidatos = candidatos;
	}
}
