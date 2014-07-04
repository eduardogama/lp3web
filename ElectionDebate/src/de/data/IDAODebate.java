package dar.data;

import java.util.List;

import entidades.Candidato;
import entidades.Debate;

public interface IDAODebate {
	
    public List<Debate> listarDebates();
	public List<Candidato> listarCandidatos();
	public void inserirDebate(Debate debate);
	
}
