package dar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Candidato;
import entidades.DAR;

public class ShowCandidatos extends AbstractCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			DAR dar = DAR.getInstance();
			List<Candidato> candidatos = dar.listarCandidatos();
			request.setAttribute("candidatos", candidatos);
			
			RequestDispatcher view = request.getRequestDispatcher("/ListarCandidatos.jsp");
			view.forward(request, response);
			
			System.out.println("ShowCandidatos");
		
		}catch(Exception e){
			request.setAttribute("msgErro", e.getMessage());			
			request.getRequestDispatcher("/error2.jsp").forward(request, response);			
		}
	}

}
