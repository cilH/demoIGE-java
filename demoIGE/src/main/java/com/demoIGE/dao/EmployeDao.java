package com.demoIGE.dao;

import java.util.List;

import com.demoIGE.model.Employe;

public interface EmployeDao {
	void ajouter(Employe employe);
	Employe lire(int noEmploye);
	void modifier(Employe employe);
	void supprimer(int noEmploye);
	List<Employe> afficherEmployes();
}
