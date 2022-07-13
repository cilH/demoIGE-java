package com.demoIGE.controller;

import java.io.IOException;
import java.sql.Timestamp;
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

@WebServlet("/AjoutServlet")
public class AjoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjoutServlet() {
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
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Employe employeAAjouter = new Employe();
		Timestamp dateNaissance = new Timestamp(0);
		Timestamp dateEmbauche = new Timestamp(0);
		employeAAjouter.setNoEmploye(Integer.parseInt(request.getParameter("noEmploye")));
		employeAAjouter.setRendCompte(Integer.parseInt(request.getParameter("rendCompte")));
		employeAAjouter.setNom(request.getParameter("nom"));
		employeAAjouter.setPrenom(request.getParameter("prenom"));
		employeAAjouter.setFonction(request.getParameter("fonction"));
		employeAAjouter.setTitre(request.getParameter("titre"));
		try {
			employeAAjouter.setTimestamp(request.getParameter("dateNaissance"));
			employeAAjouter.setDateEmbauche(sdf.parse(request.getParameter("dateEmbauche")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employeAAjouter.setSalaire(Double.parseDouble(request.getParameter("salaire")));
		employeAAjouter.setCommission(Double.parseDouble(request.getParameter("commission")));
		employeDao.ajouter(employeAAjouter);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajout.jsp").forward(request, response);
	}

}
