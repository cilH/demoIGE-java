package com.demoIGE.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoIGE.dao.DaoFactory;
import com.demoIGE.dao.EmployeDao;

@WebServlet("/EmployeServlet")
public class EmployeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeServlet() {
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

		request.setAttribute("employes", this.employeDao.afficherEmployes());

		this.getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		request.setAttribute("employes", this.employeDao.afficherEmployes());

		this.getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(request, response);
	}

}
