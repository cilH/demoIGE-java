package com.demoIGE.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoIGE.dao.DaoFactory;
import com.demoIGE.dao.EmployeDao;

@WebServlet("/SuppressionServlet")
public class SuppressionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SuppressionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private EmployeDao employeDao;

	public void init() {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.employeDao = daoFactory.getEmployeDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int noEmployeASupprimer = 0;
//		Employe employeASupprimer = new Employe();
		if (Integer.parseInt(request.getParameter("noEmploye")) != 0) {
			noEmployeASupprimer = Integer.parseInt(request.getParameter("noEmploye"));	
		}
//		employeASupprimer = employeDao.lire(noEmployeASupprimer);
		request.setAttribute("employeASupprimer", employeDao.lire(noEmployeASupprimer));
		this.getServletContext().getRequestDispatcher("/WEB-INF/suppression.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noEmployeASupprimer = 0;
//		Employe employeASupprimer = new Employe();
		if (Integer.parseInt(request.getParameter("noEmploye")) != 0) {
			noEmployeASupprimer = Integer.parseInt(request.getParameter("noEmploye"));	
		}
//		employeASupprimer = employeDao.lire(noEmployeASupprimer);
		employeDao.supprimer(noEmployeASupprimer);
		this.getServletContext().getRequestDispatcher("/WEB-INF/suppression.jsp").forward(request, response);
	}

}
