package de.controller.debate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.business.PortalDE;
import de.controller.AbstractCommand;

public class DeleteDebate extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PortalDE de = PortalDE.getInstance();
			
			String dbte = request.getParameter("nome");
			
			de.listarDebates().remove(dbte);
			
			RequestDispatcher view = request.getRequestDispatcher("/ListarDebates.jsp");
			view.forward(request, response);
			
			System.out.println("DeleteDebate");
		
		}catch(Exception e){
			request.setAttribute("msgErro", e.getMessage());			
			request.getRequestDispatcher("/error2.jsp").forward(request, response);			
		}
	}

}
