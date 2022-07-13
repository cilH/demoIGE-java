package com.demoIGE.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoIGE.dao.DaoFactory;
import com.demoIGE.dao.EmployeDao;
import com.demoIGE.model.Employe;

@WebServlet("/FormulaireServlet")
public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormulaireServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private EmployeDao employeDao;

	public void init() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.employeDao = daoFactory.getEmployeDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noEmployeAAfficher = 0;
		Employe employeAAfficher = new Employe();
		if (Integer.parseInt(request.getParameter("noEmploye")) != 0) {
			noEmployeAAfficher = Integer.parseInt(request.getParameter("noEmploye"));
		}
		employeAAfficher = employeDao.lire(noEmployeAAfficher);
		request.setAttribute("employeAAfficher", employeDao.lire(noEmployeAAfficher));
		System.out.println(noEmployeAAfficher);
		System.out.println(employeAAfficher);
		this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noEmployeAModifier = Integer.parseInt(request.getParameter("noEmploye"));
		Employe employeAModifier = new Employe();
		employeAModifier.setNoEmploye(noEmployeAModifier);
		employeAModifier.setRendCompte(Integer.parseInt(request.getParameter("rendCompte")));
		employeAModifier.setNom(request.getParameter("nom"));
		employeAModifier.setPrenom(request.getParameter("prenom"));
		employeAModifier.setFonction(request.getParameter("fonction"));
		employeAModifier.setTitre(request.getParameter("titre"));
		try {
			employeAModifier
					.setDateNaissance(new SimpleDateFormat("dd/MM/yy").parse(request.getParameter("dateNaissance")));
			employeAModifier
					.setDateEmbauche(new SimpleDateFormat("dd/MM/yy").parse(request.getParameter("dateEmbauche")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employeAModifier.setSalaire(Double.parseDouble(request.getParameter("salaire")));
		employeAModifier.setCommission(Double.parseDouble(request.getParameter("commission")));
		request.setAttribute("employeAModifier", employeAModifier);
		employeDao.modifier(employeAModifier);

		request.setAttribute("employeAAfficher", employeDao.lire(employeAModifier.getNoEmploye()));
		System.out.println(employeAModifier);
		this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
	}

}
