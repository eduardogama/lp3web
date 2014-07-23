package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.data.IDAODebate;
import de.data.memoria.DAODebateMemoria;
import entidades.Debate;

@ManagedBean
@SessionScoped
public class DebateManagedBean {

	private List<Debate> debates = new ArrayList<Debate>();
	private Debate dbte = new Debate();
	IDAODebate daoDebate;

	public DebateManagedBean() {
		this.daoDebate = new DAODebateMemoria();
	}

	public List<Debate> getDebates() {
		return debates;
	}

	public void setDebates(List<Debate> debates) {
		this.debates = debates;
	}

	public Debate getDbte() {
		return dbte;
	}

	public void setDbte(Debate dbte) {
		this.dbte = dbte;
	}

	public List<Debate> listarDebates() {
		return this.daoDebate.listarDebates();
	}

	public String CadastrarDebate() {
		try {
			daoDebate.inserirDebate(dbte);
			this.dbte = new Debate();
			return "index?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
