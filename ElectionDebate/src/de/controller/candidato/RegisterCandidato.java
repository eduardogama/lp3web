package de.controller.candidato;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.business.PortalDE;
import de.controller.AbstractCommand;
import entidades.Candidato;
import entidades.Debate;

public class RegisterCandidato extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PortalDE de = PortalDE.getInstance();

			String nome = request.getParameter("nome");
			String title = request.getParameter("title");
			String partido = request.getParameter("partido");
			String idade = request.getParameter("idade");

			Debate dbte = de.listarDebates().get(title);
			Candidato cddto = new Candidato(nome, idade, partido,dbte);
			
			request.setAttribute("debate", dbte);
			request.setAttribute("candidatos", dbte.getCandidatos());

			RequestDispatcher view = request.getRequestDispatcher("/debate-eleitoral.jsp");
			view.forward(request, response);
			
			System.out.println("RegisterCandidato");
			
		}catch(Exception e){
			request.setAttribute("msgErro", e.getMessage());			
			request.getRequestDispatcher("/error2.jsp").forward(request, response);			
		}
	}

}
