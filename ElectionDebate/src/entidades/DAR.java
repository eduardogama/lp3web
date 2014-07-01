package entidades;

import java.util.List;

import dar.business.CadastroDebates;
import dar.data.memoria.DAODebateMemoria;

public class DAR {

	private static DAR singleton = null; 
	
	private CadastroDebates cadDebates;
	
	private DAR(){
		this.cadDebates = new CadastroDebates(new DAODebateMemoria());
	}

	public static DAR getInstance(){
		
		if (singleton == null){
			singleton = new DAR();
		}		
		return singleton;
	}	
    
    public List<Debate> listarDebates(){
    	return this.cadDebates.listarDebates();
    }

	public List<Candidato> listarCandidatos(){
		return this.cadDebates.listarCandidatos();		
	}

	public void insertDebate(Debate debate){
		this.cadDebates.inserirDebate(debate);
	}
}
