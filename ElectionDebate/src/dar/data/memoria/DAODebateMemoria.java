package dar.data.memoria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import dar.data.IDAODebate;
import entidades.Candidato;
import entidades.Debate;

public class DAODebateMemoria implements IDAODebate {

	private List<Debate> debates;

	public DAODebateMemoria() {

		this.debates = new ArrayList<Debate>();

		// Debate eleitoral 1
		Debate debate = new Debate("Debate eleitoral 1");

		Candidato candidato = new Candidato("Eduardo Aranha", debate);
		candidato = new Candidato("Roberta Coelho", debate);
		candidato = new Candidato("Raoni Kulesza", debate);

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
		List<Candidato> listaCandidatos = new Vector<Candidato>();
		Debate debate;
		Candidato candidato;

		for (Iterator<Debate> i = this.debates.iterator(); i.hasNext();) {
			debate = (Debate) i.next();
			for (Iterator j = debate.getCandidatos().iterator(); j.hasNext();) {
				candidato = (Candidato) j.next();
				listaCandidatos.add(candidato);
			}
		}

		return listaCandidatos;
	}

	@Override
	public void inserirDebate(Debate debate) {
		this.debates.add(debate);
	}

}
