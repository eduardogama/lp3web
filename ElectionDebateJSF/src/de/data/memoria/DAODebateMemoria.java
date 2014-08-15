package de.data.memoria;

import java.util.ArrayList;
import java.util.List;

import de.data.IDAODebate;
import entidades.Candidato;
import entidades.Debate;
import entidades.Usuario;

public class DAODebateMemoria implements IDAODebate {

	
	private List<Usuario> usuarios;
	private List<Debate> debates;

	public DAODebateMemoria() {

		this.usuarios = new ArrayList<Usuario>();
		this.debates = new ArrayList<Debate>();

		Usuario user = new Usuario("admin", "admin");
		
		this.usuarios.add(user);
		
		// Debate eleitoral 1
		Debate debate = new Debate("Debate eleitoral 1");
		debate.setDescricao("O primeiro debate dos candidatos ao governo de Santa Catarina das eleições deste ano, "
				+ "realizado na manhã desta sexta-feira, reuniu cinco representantes dos partidos que possuem "
				+ "representação na Câmara dos Debutados. Afrânio Boppré (PSOL), Cláudio Vignatti (PT), Elpídio Neves "
				+ "(PRP), Janaina Deitos (PPL) e Paulo Bauer (PSDB) apresentaram suas campanhas e participaram de blocos "
				+ "com perguntas relacionadas as suas propostas de governo. O candidato à reeleição Raimundo Colombo "
				+ "(PSD) não participou do evento e divulgou, em nota de assessoria, que teve outros compromissos de "
				+ "governo.");

		Candidato candidato = new Candidato("Afrânio Boppré", "", "PSOL", debate);
		candidato = new Candidato("Cláudio Vignatti", "", "PT", debate);
		candidato = new Candidato("Elpídio Neves", "", "PRP", debate);
		candidato = new Candidato("Janaina Deitos", "", "PPL", debate);
		candidato = new Candidato("Paulo Bauer", "", "PSDB", debate);

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

	public void removeDebate(Debate debate) {
		this.debates.remove(debate);
	}

	@Override
	public void atualizaDebate(Debate debate) {
		// TODO Auto-generated method stub
		
	}

}
