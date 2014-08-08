package de.data.memoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.data.IDAOUsuario;
import entidades.Usuario;

public class DAOUsuarioMemoria implements IDAOUsuario{

	HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	public DAOUsuarioMemoria(){
		
		Usuario user;
		
		user = new Usuario("admin", "admin");
		this.usuarios.put(user.getLogin(), user);
		
		user = new Usuario("teste", "teste");
		this.usuarios.put(user.getLogin(), user);
	}
	
	@Override
	public void inserirUsuario(Usuario user) {
		// TODO Auto-generated method stub
		this.usuarios.put(user.getLogin(), user);
	}

	@Override
	public void removeUsuario(Usuario user) {
		// TODO Auto-generated method stub
		this.usuarios.remove(user.getLogin());
	}

	@Override
	public Usuario LogIn(String login, String pwd) {
		// TODO Auto-generated method stub
		if (this.usuarios.containsKey(login)) {
			Usuario u = this.usuarios.get(login);
			if(u.getPwd().equals(pwd)){
				return u;
			}
		}
		return null;
	}

}
