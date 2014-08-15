package de.data.bd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.data.IDAOUsuario;
import entidades.Usuario;

public class DAOUsuarioBD implements IDAOUsuario {

	protected EntityManager entityManager;

	public DAOUsuarioBD() {

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
	public void inserirUsuario(Usuario user) {
		try {
			if (!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

	@Override
	public void removeUsuario(Usuario user) {
		try {
			if (!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			// pessoa = entityManager.find(Usuario.class, pessoa.getId());
			Query query = entityManager
					.createQuery(
							"SELECT u FROM "
									+ Usuario.class.getName()
									+ " u WHERE login = :loginUsuario AND pwd = :pwdUsuario")
					.setParameter("loginUsuario", user.getLogin())
					.setParameter("pwdUsuario", user.getPwd());

			Usuario usuario = (Usuario) query.getSingleResult();

			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

	@Override
	public Usuario LogIn(String login, String pwd) {
		try {
			if(!entityManager.getTransaction().isActive())
				entityManager.getTransaction().begin();
			// pessoa = entityManager.find(Usuario.class, pessoa.getId());
			Query query = entityManager
					.createQuery(
							"SELECT u FROM "
									+ Usuario.class.getName()
									+ " u WHERE login = :loginUsuario AND pwd = :pwdUsuario")
					.setParameter("loginUsuario", login)
					.setParameter("pwdUsuario", pwd);

			// gambiarra para não lançar exceptions
			List<Usuario> usuarios = query.getResultList();
			if (usuarios.isEmpty())
				return null;
			else
				return (Usuario) query.getSingleResult();

		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		return null;
	}

}
