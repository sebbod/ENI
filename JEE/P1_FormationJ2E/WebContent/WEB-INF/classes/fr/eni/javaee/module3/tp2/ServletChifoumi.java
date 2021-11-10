package fr.eni.javaee.module3.tp2;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import fr.eni.javaee.module3.tp2.bo.ActionsPossibles;

/**
 * Servlet implementation class ServletChifoumi
 */
@WebServlet("/modules/module3/tp2/ServletChifoumi")
public class ServletChifoumi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletChifoumi() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("choix") != null) {
			processRequest(request, response);
		} else {
			// Déléguer la réponse à la JSP jeu.jsp
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module3/tp2/jeu.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (!StringUtils.isNumeric(request.getParameter("choix"))) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} else {
			int choixJoueur = Integer.parseInt(request.getParameter("choix"));
			int choixServeur = new Random().nextInt(3) + 1;
			/*
			 * choixJoueur = choixServeur =>EGALITE choixJoueur = CHI et choixServeur = MI
			 * => VICTOIRE JOUEUR choixJoueur = FOU et choixServeur = CHI => VICTOIRE JOUEUR
			 * choixJoueur = MI et choixServeur = FOU => VICTOIRE JOUEUR Dans les autres cas
			 * => VICTOIRE SERVEUR
			 * 
			 * resultat : 0 si égalité, 1 si victoire joueur, -1 si victoire serveur
			 */
			int resultat;
			if (choixJoueur == choixServeur) {
				resultat = 0;
			} else if ((choixJoueur == ActionsPossibles.CHI && choixServeur == ActionsPossibles.MI)
					|| (choixJoueur == ActionsPossibles.FOU && choixServeur == ActionsPossibles.CHI)
					|| (choixJoueur == ActionsPossibles.MI && choixServeur == ActionsPossibles.FOU)) {
				resultat = 1;
			} else {
				resultat = -1;
			}

			// Définir les informations à renvoyer à la JSP (resultat.jsp)
			request.setAttribute("resultat", resultat);
			request.setAttribute("choixJoueur", choixJoueur);
			request.setAttribute("choixServeur", choixServeur);

			// Déléguer la réponse à la JSP
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modules/module3/tp2/resultat.jsp");
			if (rd != null) {
				rd.forward(request, response);
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		}
	}

}
