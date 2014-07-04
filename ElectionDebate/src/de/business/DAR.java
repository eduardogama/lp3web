package de.business;

import java.util.HashMap;
import java.util.List;

import de.data.memoria.DAODebateMemoria;
import entidades.Candidato;
import entidades.Debate;

public class DAR {

	private static DAR singleton = null;

	private CadastroDebates cadDebates;

	private DAR() {
		this.cadDebates = new CadastroDebates(new DAODebateMemoria());
	}

	public static DAR getInstance() {
		if (singleton == null) {
			singleton = new DAR();
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

	public Debate getDebateporNome(String nome) {

		for (Debate dbte : listarDebates().values()) {
			if (dbte.getNome().equals(nome)) {
				return dbte;
			}
		}

		return null;
	}
}