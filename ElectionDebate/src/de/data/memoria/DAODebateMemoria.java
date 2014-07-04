package de.data.memoria;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import de.data.IDAODebate;
import entidades.Candidato;
import entidades.Debate;

public class DAODebateMemoria implements IDAODebate {

	private HashMap<String, Debate> debates;

	public DAODebateMemoria() {

		this.debates = new HashMap<String, Debate>();

		// Debate eleitoral 1
		Debate debate = new Debate("Debate eleitoral 1");

		Candidato candidato = new Candidato("Eduardo Aranha", debate);
		candidato = new Candidato("Roberta Coelho", debate);
		candidato = new Candidato("Raoni Kulesza", debate);

		this.debates.put(debate.getNome(), debate);

		// Debate eleitoral 2
		debate = new Debate("Debate eleitoral 2");

		this.debates.put(debate.getNome(), debate);

		// Debate eleitoral 3
		debate = new Debate("Debate eleitoral 3");

		this.debates.put(debate.getNome(), debate);
	}

	@Override
	public HashMap<String, Debate> listarDebates() {
		return this.debates;
	}

	@Override
	public HashMap<String, Candidato> listarCandidatos() {
		HashMap<String, Candidato> listaCandidatos = new HashMap<String, Candidato>();
		
		for (Debate dbte : debates.values()) {
			for (Candidato cdto : dbte.getCandidatos()) {
				listaCandidatos.put(cdto.getNome(),cdto);
			}
		}
	
		return listaCandidatos;
	}

	@Override
	public void inserirDebate(Debate debate) {
		this.debates.put(debate.getNome(),debate);
	}

}
