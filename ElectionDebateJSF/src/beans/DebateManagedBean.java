package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import de.data.IDAODebate;
import de.data.memoria.DAODebateMemoria;
import entidades.Candidato;
import entidades.Debate;
import entidades.Pergunta;

@ManagedBean
@SessionScoped
public class DebateManagedBean {

	private IDAODebate daoDebate;
	private List<Debate> debates = new ArrayList<Debate>();
	private Debate dbte = new Debate();
	private Debate selected_dbte = new Debate();
	private Debate edit_dbte;
	private Candidato new_cdto = new Candidato();
	private Candidato edit_cdto = new Candidato();
	private Pergunta new_pergunta = new Pergunta();

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

	public Debate getSelected_dbte() {
		return selected_dbte;
	}

	public void setSelected_dbte(Debate selected_dbte) {
		this.selected_dbte = selected_dbte;
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
	
	public String EditarDebate(Debate dbte){
		return "index";
	}

	public String DeleteDebate(Debate dbte) {
		this.daoDebate.removeDebate(dbte);
		return "index";
	}
	public String DeleteCandidato(Candidato cdto){
		this.selected_dbte.getCandidatos().remove(cdto);
		return "view-debate";
	}

	public String RegistrarCandidato() {
		selected_dbte.addCandidato(new_cdto);
		this.new_cdto = new Candidato();
		return "view-debate";
	}
	
	public String RemoverPergunta(Pergunta p){
		this.selected_dbte.getPerguntas().remove(p);
		return "view-debate";
	}
	
	public String EditarCandidato(){
		return "view-debate";
	}

	public Candidato getNew_cdto() {
		return new_cdto;
	}

	public void setNew_cdto(Candidato new_cdto) {
		this.new_cdto = new_cdto;
	}

	public Debate getEdit_dbte() {
		return edit_dbte;
	}

	public void setEdit_dbte(Debate edit_dbte) {
		this.edit_dbte = edit_dbte;
	}
	
	public List<String> getKeyAsList(Pergunta pegto){ 
		if(pegto == null)
			return new ArrayList<String>();
		return new ArrayList<String>(pegto.getCandidatos().keySet()); 
	}
	
	public String VotarCandidato(String key,Pergunta pgta){
		pgta.getCandidatos().put(key, pgta.getCandidatos().get(key) + 1);
		return "view-debate";
	}
	
	public String CadastrarPergunta(){
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for (Candidato cdto : this.selected_dbte.getCandidatos()) {
			hm.put(cdto.getNome(), 0);
		}
		this.new_pergunta.setCandidatos(hm);
		this.selected_dbte.getPerguntas().add(new_pergunta);
		
		this.new_pergunta = new Pergunta();
		
		return "view-debate";
	}

	public void validateDebate(ComponentSystemEvent event) {

		FacesContext fc = FacesContext.getCurrentInstance();

		UIComponent components = event.getComponent();

		// get password
		UIInput uiInputNome = (UIInput) components.findComponent("nome");
		String nome = uiInputNome.getLocalValue() == null ? "" : uiInputNome
				.getLocalValue().toString();
		String nomeId = uiInputNome.getClientId();

		// Let required="true" do its job.
		if (nome.isEmpty()) {
			return;
		}

		for (Debate dbte : daoDebate.listarDebates()) {
			if (dbte.getNome().equals(nome)) {
				FacesMessage msg = new FacesMessage("Nome debate já existe");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				fc.addMessage(nomeId, msg);
				fc.renderResponse();
			}

		}
	}

	public Candidato getEdit_cdto() {
		return edit_cdto;
	}

	public void setEdit_cdto(Candidato edit_cdto) {
		this.edit_cdto = edit_cdto;
	}

	public Pergunta getNew_pergunta() {
		return new_pergunta;
	}

	public void setNew_pergunta(Pergunta new_pergunta) {
		this.new_pergunta = new_pergunta;
	}
}
