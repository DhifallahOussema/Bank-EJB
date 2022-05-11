package tn.enis.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tn.enis.entity.Client;
import tn.enis.service.ClientService;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClientService clientService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		if ("prepareUpdate".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			Client client = clientService.getById(cin);
			
			Gson gson= new Gson();
			String json = gson.toJson(client);
			System.out.println(json);


			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json);
			
//			request.setAttribute("client", client);
//			request.getRequestDispatcher("majClient.jsp").forward(request, response);
//			return;
		}else
		{
			request.setAttribute("clients", clientService.getAll());
			request.getRequestDispatcher("clients.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("add".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");

			Client client = new Client(cin, nom, prenom, adresse);
			clientService.save(client);
		}
		if ("update".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adresse = request.getParameter("adresse");

			Client client = new Client(cin, nom, prenom, adresse);
			clientService.update(client);
		}
		if ("delete".equals(request.getParameter("action"))) {
			String cin = request.getParameter("cin");
			clientService.delete(cin);
		}
		request.setAttribute("clients", clientService.getAll());
		request.getRequestDispatcher("clients.jsp").forward(request, response);
		
	}

}
