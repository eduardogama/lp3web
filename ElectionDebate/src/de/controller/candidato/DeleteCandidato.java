package de.controller.candidato;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.business.PortalDE;
import de.controller.AbstractCommand;
import entidades.Candidato;
import entidades.Debate;

public class DeleteCandidato extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			System.out.println("DeleteCandidato");
			PortalDE de = PortalDE.getInstance();
			
			String dbte = request.getParameter("title");
			String cddto = request.getParameter("nome");
			

			System.out.println("DeleteCandidato : " + dbte + " " + cddto);

			de.removeCandidato(dbte, cddto);
						
			RequestDispatcher view = request.getRequestDispatcher("/debate-eleitoral.jsp");
			view.forward(request, response);
			
			System.out.println("DeleteCandidato");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());			
			request.getRequestDispatcher("/error2.jsp").forward(request, response);			
		}
	}

}
