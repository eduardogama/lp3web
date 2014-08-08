package de.data;

import entidades.Usuario;

public interface IDAOUsuario {

	public void inserirUsuario(Usuario user);
	public void removeUsuario(Usuario user);
	public Usuario LogIn(String login, String pwd);

}
