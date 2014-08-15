package de.data.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.data.IDAOCandidato;
import entidades.Candidato;
import entidades.Debate;

public class DAOCandidatoBD implements IDAOCandidato {

	protected EntityManager entityManager;

	public DAOCandidatoBD() {

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

	@Override
	public Candidato inserirCandidato(Candidato candidato) {
		try {
			if (!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			entityManager.persist(candidato);
			entityManager.getTransaction().commit();
			entityManager.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
			//entityManager.getTransaction().rollback();
		}
		return candidato; 
	}

	@Override
	public void atualizaCandidato(Candidato candidato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCandidato(Candidato candidato) {
		try {
			if (!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			Candidato can = entityManager.find(Candidato.class, candidato.getIdCandidato());
			entityManager.remove(can);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

}
