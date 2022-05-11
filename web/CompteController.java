package tn.enis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import tn.enis.entity.Client;
import tn.enis.entity.Compte;
import tn.enis.service.ClientService;
import tn.enis.service.CompteService;

/**
 * Servlet implementation class CompteController
 */
@WebServlet("/CompteController")
public class CompteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CompteService compteService;
	@EJB
	private ClientService clientService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("add".equals(request.getParameter("action"))) {
			Client client = clientService.getById(request.getParameter("client"));
			float solde = Float.parseFloat(request.getParameter("solde"));

			Compte compte = new Compte(solde, client);
			compteService.save(compte);
		}

		if ("prepareUpdate".equals(request.getParameter("action"))) {
			Long rib = Long.parseLong(request.getParameter("rib"));
			Compte compte = compteService.getById(rib);

			request.setAttribute("compte", compte);
			request.getRequestDispatcher("maj.jsp").forward(request, response);
			return;
		}
		if("getCin".equals(request.getParameter("action"))) {
			List<String> cinList = new ArrayList<String>();
			List<Client> clients =  clientService.getAll();
			for(Client c:clients) {
				cinList.add(c.getCin());
			}
			Gson gson= new Gson();
			String json = gson.toJson(cinList);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json);
			return;
			
		}

		if ("update".equals(request.getParameter("action"))) {
			Long rib = Long.parseLong(request.getParameter("rib"));
			Client client = clientService.getById(request.getParameter("client"));

			float solde = Float.parseFloat(request.getParameter("solde"));

			Compte compte = new Compte(rib, solde, client);
			compteService.update(compte);
		}

		if ("delete".equals(request.getParameter("action"))) {
			Long rib = Long.parseLong(request.getParameter("rib"));
			compteService.delete(rib);
		}

		request.setAttribute("comptes", compteService.getAll());
		request.getRequestDispatcher("comptes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
