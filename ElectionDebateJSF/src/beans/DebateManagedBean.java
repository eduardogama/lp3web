package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import de.data.IDAOCandidato;
import de.data.IDAODebate;
import de.data.IDAOPergunta;
import de.data.bd.DAOCandidatoBD;
import de.data.bd.DAODebateBD;
import de.data.bd.DAOPerguntaBD;
import entidades.Candidato;
import entidades.Debate;
import entidades.Pergunta;

@ManagedBean
@SessionScoped
public class DebateManagedBean {

	private IDAODebate daoDebate;
	private IDAOCandidato daoCandidato;
	private IDAOPergunta daoPergunta;
	private Debate edit_dbte;
	private Debate dbte = new Debate();
	private Debate selected_dbte = new Debate();
	private List<Debate> debates = new ArrayList<Debate>();
	private Candidato new_cdto = new Candidato();
	private Candidato edit_cdto = new Candidato();
	private Pergunta new_pergunta = new Pergunta();	
	public DebateManagedBean() {
		//this.daoDebate = new DAODebateMemoria();
		this.daoDebate = new DAODebateBD();
		this.daoCandidato = new DAOCandidatoBD();
		this.daoPergunta = new DAOPerguntaBD();
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
		return "index?faces-redirect=true";
	}

	public String DeleteDebate(Debate dbte) {
		this.daoDebate.removeDebate(dbte);
		return "index?faces-redirect=true";
	}
	public String DeleteCandidato(Candidato cdto){
		this.selected_dbte.getCandidatos().remove(cdto);
		daoCandidato.atualizaCandidato(cdto);
		daoDebate.atualizaDebate(selected_dbte);
		return "view-debate?faces-redirect=true";
	}

	public String RegistrarCandidato() {
		//cadidato com a variavel id instanciada
		Candidato candidatoRegistrado = daoCandidato.inserirCandidato(new_cdto);		
		selected_dbte.addCandidato(candidatoRegistrado);
		daoDebate.atualizaDebate(selected_dbte);
		this.new_cdto = new Candidato();
		return "view-debate?faces-redirect=true";
	}
	
	public String RemoverPergunta(Pergunta p){
		System.out.println("[Remover Pergunta] ");
		this.selected_dbte.getPerguntas().remove(p);
		System.out.println("[Remover Pergunta] ");

		daoPergunta.removePergunta(p);
		System.out.println("[Remover Pergunta] ");

		daoDebate.atualizaDebate(selected_dbte);
		System.out.println("[Remover Pergunta] ");

		return "view-debate?faces-redirect=true";
	}
	
	public String EditarCandidato(){
		return "view-debate?faces-redirect=true";
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
		daoPergunta.atualizaPergunta(pgta);
		return "view-debate?faces-redirect=true";
	}
	
	public String CadastrarPergunta(){
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for (Candidato cdto : this.selected_dbte.getCandidatos()) {
			hm.put(cdto.getNome(), 0);
		}
		this.new_pergunta.setCandidatos(hm);
		Pergunta perCadastrada = daoPergunta.inserirPergunta(new_pergunta);
		this.selected_dbte.getPerguntas().add(perCadastrada);
		daoDebate.atualizaDebate(selected_dbte);
		this.new_pergunta = new Pergunta();
		
		return "view-debate?faces-redirect=true";
	}

	public void validateDebate(ComponentSystemEvent event) {
//
//		FacesContext fc = FacesContext.getCurrentInstance();
//
//		UIComponent components = event.getComponent();
//
//		// get password
//		UIInput uiInputNome = (UIInput) components.findComponent("nome");
//		String nome = uiInputNome.getLocalValue() == null ? "" : uiInputNome
//				.getLocalValue().toString();
//		String nomeId = uiInputNome.getClientId();
//
//		// Let required="true" do its job.
//		if (nome.isEmpty()) {
//			return;
//		}
//
//		for (Debate dbte : daoDebate.listarDebates()) {
//			if (dbte.getNome().equals(nome)) {
//				FacesMessage msg = new FacesMessage("Nome debate já existe");
//				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
//				fc.addMessage(nomeId, msg);
//				fc.renderResponse();
//			}
//
//		}  
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
