package de.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.business.PortalDE;
import entidades.Candidato;

public class ShowCandidatos extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			PortalDE portalDE = PortalDE.getInstance();
			HashMap<String,Candidato> candidatos = portalDE.listarCandidatos();
			request.setAttribute("candidatos", candidatos.values());
			
			RequestDispatcher view = request.getRequestDispatcher("/ListarCandidatos.jsp");
			view.forward(request, response);
			
			System.out.println("ShowCandidatos");
		
		}catch(Exception e){
			request.setAttribute("msgErro", e.getMessage());			
			request.getRequestDispatcher("/error2.jsp").forward(request, response);			
		}
	}
}
