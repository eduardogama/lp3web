package de.controller;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.controller.candidato.DeleteCandidato;
import de.controller.candidato.RegisterCandidato;
import de.controller.debate.DeleteDebate;
import de.controller.debate.EditDebate;
import de.controller.debate.RegisterDebate;
import de.controller.debate.ShowDebate;
import de.controller.debate.ShowDebates;

/**
 * Servlet implementation class ServletDE
 */
@WebServlet("/ServletDE")
public class ServletDE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Hashtable<String, AbstractCommand> commands;

	public void init(ServletConfig config) throws ServletException {

		this.commands = new Hashtable<String, AbstractCommand>();

		this.commands.put("ShowDebates", new ShowDebates());
		this.commands.put("ShowDebate", new ShowDebate());
		this.commands.put("RegisterDebate", new RegisterDebate());
		this.commands.put("DeleteDebate", new DeleteDebate());
		this.commands.put("EditDebate", new EditDebate());

		this.commands.put("RegisterCandidato", new RegisterCandidato());
		this.commands.put("DeleteCandidato", new DeleteCandidato());
		this.commands.put("ShowCandidatos", new ShowCandidatos());

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDE() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String cmd = request.getParameter("comando");
				
		try {
			AbstractCommand command = (AbstractCommand) commands.get(cmd);
			command.execute(request, response);

		} catch (Exception e) {
			request.setAttribute(
					"msgErro",
					"Erro grave de Sistema: Contacte o Administrador \n"
							+ e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
		}
	}
}
