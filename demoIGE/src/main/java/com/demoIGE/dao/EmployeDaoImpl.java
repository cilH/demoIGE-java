package com.demoIGE.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demoIGE.model.Employe;

public class EmployeDaoImpl implements EmployeDao {

	private DaoFactory daoFactory;
	private String message;

	public EmployeDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void ajouter(Employe employe) {
		Connection connexion = null;
		PreparedStatement ps = null;
		try {
			connexion = daoFactory.getConnection();
			ps = connexion.prepareStatement(
					"INSERT INTO EMPLOYES(NO_EMPLOYE, REND_COMPTE, NOM, PRENOM, FONCTION, TITRE, DATE_NAISSANCE, DATE_EMBAUCHE, SALAIRE, COMMISSION)" 
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, employe.getNoEmploye());
			ps.setInt(2, employe.getRendCompte());
			ps.setString(3, employe.getNom());
			ps.setString(4, employe.getPrenom());
			ps.setString(5, employe.getFonction());
			ps.setString(6, employe.getTitre());
			ps.setDate(7, (Date) employe.getDateNaissance());
			ps.setDate(8, (Date) employe.getDateEmbauche());
			ps.setDouble(9, employe.getSalaire());
			ps.setDouble(10, employe.getCommission());
			ps.executeUpdate();
		} catch (SQLException e) {
			this.message = e.getMessage();
		}
	}

	@Override
	public Employe lire(int noEmploye) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employe employeAAfficher = new Employe();
		try {
			connection = daoFactory.getConnection();
			ps = connection.prepareStatement(
					"SELECT * FROM EMPLOYES WHERE NO_EMPLOYE=?");
			ps.setInt(1, noEmploye);
			rs = ps.executeQuery();
			while(rs.next()) {
				int rendCompte = rs.getInt("REND_COMPTE");
				String nom = rs.getString("NOM");
				String prenom = rs.getString("PRENOM");
				String fonction = rs.getString("FONCTION");
				String titre = rs.getString("TITRE");
				Date dateNaissance= rs.getDate("DATE_NAISSANCE");
				Date dateEmbauche= rs.getDate("DATE_EMBAUCHE");
				double salaire = rs.getDouble("SALAIRE");
				double commission = rs.getDouble("COMMISSION");
				
				employeAAfficher.setNoEmploye(noEmploye);
				employeAAfficher.setRendCompte(rendCompte);
				employeAAfficher.setNom(nom);
				employeAAfficher.setPrenom(prenom);
				employeAAfficher.setFonction(fonction);
				employeAAfficher.setTitre(titre);
				employeAAfficher.setDateNaissance(dateNaissance);
				employeAAfficher.setDateEmbauche(dateEmbauche);
				employeAAfficher.setSalaire(salaire);
				employeAAfficher.setCommission(commission);
			}
		}
		catch (Exception e) {
			this.message = e.getMessage();
		}
		return employeAAfficher;
	}

	@Override
	public void modifier(Employe employe) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = daoFactory.getConnection();
			ps = connection.prepareStatement(
					"UPDATE EMPLOYES"
					+ "SET REND_COMPTE=?, NOM=?, PRENOM=?, FONCTION=?, TITRE=?, DATE_NAISSANCE=?, DATE_EMBAUCHE=?, SALAIRE=?, COMMISSION=?"
					+ "WHERE NO_EMPLOYE=?");
			ps.setInt(1, employe.getRendCompte());
			ps.setString(2, employe.getNom());
			ps.setString(3, employe.getPrenom());
			ps.setString(4, employe.getFonction());
			ps.setString(5, employe.getTitre());
			ps.setDate(6, (Date) employe.getDateNaissance());
			ps.setDate(7, (Date) employe.getDateEmbauche());
			ps.setDouble(8, employe.getSalaire());
			ps.setDouble(9, employe.getCommission());
			ps.setInt(10, employe.getNoEmploye());
			ps.executeUpdate();
			this.message = "Employé modifié";
		}
		catch(SQLException e) {
			this.message = e.getMessage();
		}

	}

	@Override
	public void supprimer(int noEmploye) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = daoFactory.getConnection();
			ps = connection.prepareStatement(
					"DELETE FROM EMPLOYES WHERE NO_EMPLOYE =?");
			ps.setInt(1, noEmploye);
			ps.executeUpdate();
			this.message = "Employe supprimé";
		}
		catch (SQLException e){
			this.message = e.getMessage();
		}
		System.out.println(message);
	}

	@Override
	public List<Employe> afficherEmployes() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<Employe> employes = new ArrayList<Employe>();
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM EMPLOYES ORDER BY NO_EMPLOYE");
			while (rs.next()) {
				int noEmploye = rs.getInt("NO_EMPLOYE");
				String nom = rs.getString("NOM");
				String prenom = rs.getString("PRENOM");
				String fonction = rs.getString("FONCTION");
				double salaire = rs.getDouble("SALAIRE");
				
				Employe employeAAfficher = new Employe();
				employeAAfficher.setNoEmploye(noEmploye);
				employeAAfficher.setNom(nom);
				employeAAfficher.setPrenom(prenom);
				employeAAfficher.setFonction(fonction);
				employeAAfficher.setSalaire(salaire);
			
				employes.add(employeAAfficher);
			}
		} catch (SQLException e) {
			this.message = e.getMessage();
		}
		return employes;
	}

}
