package dar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.*;

public class ShowDebates extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			DAR dar = DAR.getInstance();
			List<Debate> debates = dar.listarDebates();
			request.setAttribute("debates", debates);
			
			RequestDispatcher view = request.getRequestDispatcher("/ListarDebates.jsp");
			view.forward(request, response);
			
			System.out.println("ShowDebates");
		
		}catch(Exception e){
			request.setAttribute("msgErro", e.getMessage());			
			request.getRequestDispatcher("/error2.jsp").forward(request, response);			
		}
	}

}
