package de.data.bd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.data.IDAODebate;
import entidades.Candidato;
import entidades.Debate;

public class DAODebateBD implements IDAODebate {

	protected EntityManager entityManager;

	private List<Debate> debates;

	public DAODebateBD() {

		this.debates = new ArrayList<Debate>();
		this.entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("ElectionDebatePU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Debate> listarDebates() {
		debates = entityManager.createQuery("FROM " + Debate.class.getName())
				.getResultList();
		if (!debates.isEmpty())
			return debates;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidato> listarCandidatos() {
		ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
		candidatos = (ArrayList<Candidato>) entityManager.createQuery(
				"FROM " + Candidato.class.getName()).getResultList();
		if (!candidatos.isEmpty())
			return candidatos;
		return null;
	}

	@Override
	public void inserirDebate(Debate debate) {
		try {
			if (!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			entityManager.persist(debate);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

	@Override
	public void removeDebate(Debate debate) {
		try {
			if (!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			Debate deb = entityManager.find(Debate.class, debate.getIdDebate());
			entityManager.remove(deb);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

	@Override
	public void atualizaDebate(Debate debate) {
		try {
			if (!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			entityManager.merge(debate);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

}
