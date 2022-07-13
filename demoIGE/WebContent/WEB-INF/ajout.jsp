<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/demoIGE/style.css" rel="stylesheet">
<title>Ajout employé</title>
</head>
<body>
<%@ include file="header.jsp"%>
	<%@ include file="menu.jsp"%>

	<section id="formulaire">
	<h2>Ajout employé</h2>
		<form action="" method="post" class="row g-3">

			<div class="row">
				<div class="col-2">
					<label class="form-label" for="noEmploye">No de l'employé : </label>
					<input class="form-control" type="number" id="noEmploye" name="noEmploye">
				</div>
			</div>
			
			<fieldset class="container">
				<legend>Informations personnelles</legend>
				<div class="row mb-3">
					<div class="col-2">
						<label class="form-label" for="titre">Titre : </label>
						<input class="form-control" type="text" id="titre" name="titre" required>
					</div>
					<div class="col-4">
						<label class="form-label" for="nom">Nom : </label>
						<input class="form-control" type="text" id="nom" name="nom" required>
					</div>
					<div class="col-4">
						<label class="form-label" for="prenom">Prénom : </label>
						<input class="form-control" type="text" id="prenom" name="prenom" required>
					</div>
					<div class="col-2">
						<label class="form-label" for="dateNaissance">Date de naissance : </label>
						<input class="form-control" type="date" id="dateNaissance" name="dateNaissance" required>
					</div>
				</div>
			</fieldset>
			
			<fieldset class="container">
				<legend>Informations professionnelles</legend>
				<div class="row mt-3">
					<div class="col-2">
						<label class="form-label" for="dateEmbauche">Date d'embauche : </label>
						<input class="form-control" type="date" id="dateEmbauche" name="dateEmbauche" required>
					</div>
					<div class="col-7">
						<label class="form-label" for="fonction">Fonction : </label>
						<input class="form-control" type="text" id="fonction" name="fonction" required>
					</div>
					<div class="col-3">
						<label class="form-label" for="rendCompte">Rend compte : </label>
						<input class="form-control" type="text" id="rendCompte" name="rendCompte" required>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col">
						<label class="form-label" for="salaire">Salaire : </label>
						<input class="form-control" type="number" id="salaire" name="salaire" required>
					</div>
					<div class="col">
						<label class="form-label" for="commission">Commission : </label>
						<input class="form-control" value="0" type="number" id="commission" name="commission" required>
					</div>
				</div>
			</fieldset>
			<div class="container mt-5">
				<button type="submit" class="btn btn-secondary offset-11 col-1">Ajouter</button>
			</div>
		</form>
		
	</section>
</body>
</html>