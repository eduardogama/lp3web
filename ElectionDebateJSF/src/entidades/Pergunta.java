package entidades;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
@Entity
public class Pergunta {
	@Id
	@GeneratedValue
	private long idPergunta;
	private String prgta;
	
	//@OneToMany(mappedBy="pergunta")
	//@MapKey(name="number")
	@ElementCollection
	private Map<String, Integer> candidatos = (Map<String, Integer>) new HashMap<String, Integer>();

	public long getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(long idPergunta) {
		this.idPergunta = idPergunta;
	}

	public String getPrgta() {
		return prgta;
	}

	public void setPrgta(String prgta) {
		this.prgta = prgta;
	}

	public Map<String, Integer> getCandidatos() {
		return  candidatos;
	}

	public void setCandidatos(Map<String, Integer> candidatos) {
		this.candidatos =  candidatos;
	}
}
