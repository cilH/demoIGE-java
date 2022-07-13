package com.demoIGE.model;

import java.util.Date;

public class Employe {
	private int noEmploye;
	private int rendCompte;
	private String nom;
	private String prenom;
	private String fonction;
	private String titre;
	private Date dateNaissance;
	private Date dateEmbauche;
	private double salaire;
	private double commission;

	public int getNoEmploye() {
		return noEmploye;
	}

	public void setNoEmploye(int noEmploye) {
		this.noEmploye = noEmploye;
	}

	public int getRendCompte() {
		return rendCompte;
	}

	public void setRendCompte(int rendCompte) {
		this.rendCompte = rendCompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date date) {
		this.dateNaissance = date;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date date) {
		this.dateEmbauche = date;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	@Override
	public String toString() {
		return "Employe [noEmploye=" + noEmploye + ", rendCompte=" + rendCompte + ", nom=" + nom + ", prenom=" + prenom
				+ ", fonction=" + fonction + ", titre=" + titre + ", dateNaissance=" + dateNaissance
				+ ", dateEmbauche=" + dateEmbauche + ", salaire=" + salaire + ", commission=" + commission + "]";
	}

	
	
}
