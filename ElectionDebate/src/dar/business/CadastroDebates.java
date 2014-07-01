package dar.business;

import java.util.ArrayList;
import java.util.List;

import dar.data.IDAODebate;
import entidades.Candidato;
import entidades.Debate;

public class CadastroDebates {
	
	IDAODebate daoDebate;
	
	public CadastroDebates(IDAODebate dao){
		this.daoDebate = dao;
	}
	
    public List<Debate> listarDebates(){
    	return this.daoDebate.listarDebates();
    }

	public List<Candidato> listarCandidatos() {
		return this.daoDebate.listarCandidatos();
	}

	public void inserirDebate(Debate debate) {
		this.validarDebate(debate);
		this.daoDebate.inserirDebate(debate);
	}

	private void validarDebate(Debate debate){
		boolean erro = false;
		List<String> mensagensErros = new ArrayList<String>();
		
		if (debate == null){
			erro = true;
			mensagensErros.add("Departamento Invalido");
			
		}
		if (debate.getNome() == null || debate.getNome().trim().equals("")){
			erro = true;
			mensagensErros.add("Nome Invalido");
			
		}		
	}

}
