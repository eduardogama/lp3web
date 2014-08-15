package de.data;

import entidades.Candidato;

public interface IDAOCandidato {
	
	public Candidato inserirCandidato(Candidato candidato);
	public void atualizaCandidato(Candidato candidato);
	public void removeCandidato(Candidato candidato);

}
