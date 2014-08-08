package de.controller.debate;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.business.PortalDE;
import de.controller.AbstractCommand;
import entidades.Debate;

public class EditDebate extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PortalDE de = PortalDE.getInstance();
			
			String title = request.getParameter("title");
			
			HashMap<String,Debate> debates = de.listarDebates();
			
			Debate dbte = debates.get(title);
			
			
			dbte.setNome(request.getParameter("nome"));
			dbte.setDescricao(request.getParameter("descricao"));
			dbte.setData(request.getParameter("data"));
			
			debates.remove(title);
			de.insertDebate(dbte);
			
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.forward(request, response);
			
			System.out.println("EditDebate " + dbte.getNome() + " " + dbte.getDescricao());
		}catch(Exception e){
			request.setAttribute("msgErro", e.getMessage());			
			request.getRequestDispatcher("/error2.jsp").forward(request, response);			
		}
	}

}
