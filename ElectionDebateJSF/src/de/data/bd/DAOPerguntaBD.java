package de.data.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.data.IDAOPergunta;
import entidades.Debate;
import entidades.Pergunta;

public class DAOPerguntaBD implements IDAOPergunta{

	protected EntityManager entityManager;
	
	public DAOPerguntaBD() {
		
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
	public Pergunta inserirPergunta(Pergunta pergunta) {
		try {
			if (!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			entityManager.persist(pergunta);
			entityManager.getTransaction().commit();
			entityManager.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
			//entityManager.getTransaction().rollback();
		}
		return pergunta; 
	}

	@Override
	public void atualizaPergunta(Pergunta pergunta) {
		try {
			if (!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			entityManager.merge(pergunta);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

	@Override
	public void removePergunta(Pergunta pergunta) {
		try {
			if (!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			Pergunta per = entityManager.find(Pergunta.class, pergunta.getIdPergunta());
			entityManager.remove(per);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

}
