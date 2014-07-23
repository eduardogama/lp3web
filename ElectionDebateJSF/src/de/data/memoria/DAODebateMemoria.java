package de.data.memoria;

import java.util.ArrayList;
import java.util.List;

import de.data.IDAODebate;
import entidades.Candidato;
import entidades.Debate;

public class DAODebateMemoria implements IDAODebate {

	private List<Debate> debates;

	public DAODebateMemoria() {

		this.debates = new ArrayList<Debate>();

		// Debate eleitoral 1
		Debate debate = new Debate("Debate eleitoral 1");

		Candidato candidato = new Candidato("Aecio Neves","","", debate);
		candidato = new Candidato("Eduardo Campos","","", debate);
		candidato = new Candidato("Dilma Roussef","","", debate);

		this.debates.add(debate);

		// Debate eleitoral 2
		debate = new Debate("Debate eleitoral 2");

		this.debates.add(debate);

		// Debate eleitoral 3
		debate = new Debate("Debate eleitoral 3");

		this.debates.add(debate);
	}

	@Override
	public List<Debate> listarDebates() {
		return this.debates;
	}

	@Override
	public List<Candidato> listarCandidatos() {
		List<Candidato> listaCandidatos = new ArrayList<Candidato>();
		
		for (Debate dbte : debates) {
			for (Candidato cdto : dbte.getCandidatos()) {
				listaCandidatos.add(cdto);
			}
		}
		return listaCandidatos;
	}

	@Override
	public void inserirDebate(Debate debate) {
		this.debates.add(debate);
	}

}
