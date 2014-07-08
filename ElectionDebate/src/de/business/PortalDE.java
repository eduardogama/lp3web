package de.business;

import java.util.HashMap;
import java.util.List;

import de.data.memoria.DAODebateMemoria;
import entidades.Candidato;
import entidades.Debate;

public class PortalDE {

	private static PortalDE singleton = null;

	private CadastroDebates cadDebates;

	private PortalDE() {
		this.cadDebates = new CadastroDebates(new DAODebateMemoria());
	}

	public static PortalDE getInstance() {
		if (singleton == null) {
			singleton = new PortalDE();
		}
		return singleton;
	}

	public HashMap<String, Debate> listarDebates() {
		return this.cadDebates.listarDebates();
	}

	public HashMap<String, Candidato> listarCandidatos() {
		return this.cadDebates.listarCandidatos();
	}

	public void insertDebate(Debate debate) {
		this.cadDebates.inserirDebate(debate);
	}
	
	public void removeDebate(String debate){
		this.cadDebates.listarDebates().remove(debate);	
	}
	
	public void removeCandidato(String dbte, String cddto){
		this.cadDebates.removeCandidato(dbte, cddto);
	}
	
	public Debate getDebateporNome(String nome) {

		for (Debate dbte : listarDebates().values()) {
			if (dbte.getNome().equals(nome)) {
				return dbte;
			}
		}

		return null;
	}
}
