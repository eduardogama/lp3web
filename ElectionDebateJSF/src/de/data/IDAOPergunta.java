package de.data;

import entidades.Pergunta;

public interface IDAOPergunta {

	public Pergunta inserirPergunta(Pergunta pergunta);
	public void atualizaPergunta(Pergunta pergunta);
	public void removePergunta(Pergunta pergunta);
}
