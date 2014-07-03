package dar.business;

import java.util.List;

import entidades.Candidato;

public class CadastroCandidatos {

	private CadastroCandidatos daoDebate;

	public List<Candidato> listarCandidatos() {
		return this.daoDebate.listarCandidatos();
	}
}
