package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.data.IDAOUsuario;
import de.data.bd.DAOUsuarioBD;
import de.data.memoria.DAOUsuarioMemoria;
import entidades.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioManagedBean {

	private IDAOUsuario daoUsuario;
	private String login;
	private String pwd;
	private Usuario user;

	public UsuarioManagedBean() {
		// TODO Auto-generated constructor stub
		this.daoUsuario = new DAOUsuarioBD();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String LogIn() {
		this.user = daoUsuario.LogIn(login, pwd);
		
		
		if (this.user != null){
			System.out.println(">>>> " + user.getLogin() +  " " + user.getPwd());
			this.login = this.pwd = null;
			return "index?faces-redirect=true";
		}else{
			System.out.println("ENtrou");
			return null;
		}
	}
	
	public String LogOut(){
		this.user = null;
		return "index?faces-redirect=true";
	}
}
