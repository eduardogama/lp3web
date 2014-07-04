package de.controller.debate;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.business.PortalDE;
import de.controller.AbstractCommand;
import entidades.Debate;

public class ShowDebate  extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			PortalDE de = PortalDE.getInstance();
			
			String nome = request.getParameter("nome");

			Debate debate = de.getDebateporNome(nome);
			
			request.setAttribute("debate", debate);
			
			RequestDispatcher view = request.getRequestDispatcher("/debate-eleitoral.jsp");
			view.forward(request, response);
			
			System.out.println("ShowDebate");
		
		}catch(Exception e){
			request.setAttribute("msgErro", e.getMessage());			
			request.getRequestDispatcher("/error2.jsp").forward(request, response);			
		}
	}

}
