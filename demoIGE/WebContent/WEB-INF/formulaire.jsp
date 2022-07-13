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
<title>Formulaire employé</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="menu.jsp"%>

	<section id="formulaire">
	<h2>Détails employé</h2>
		<form action="" method="post" class="row g-3">

			<div class="row">
				<div class="col-2">
					<label class="form-label" for="noEmploye">No de l'employé : </label>
					<input class="form-control" type="number" id="noEmploye" name="noEmploye" value="<c:out value="${ employeAAfficher.noEmploye }"/>" readonly required>
				</div>
			</div>
			
			<fieldset class="container">
				<legend>Informations personnelles</legend>
				<div class="row mb-3">
					<div class="col-2">
						<label class="form-label" for="titre">Titre : </label>
						<input class="form-control" type="text" id="titre" name="titre" value="<c:out value="${ employeAAfficher.titre }"/>" required>
					</div>
					<div class="col-4">
						<label class="form-label" for="nom">Nom : </label>
						<input class="form-control" type="text" id="nom" name="nom" value="<c:out value="${ employeAAfficher.nom }"/>" required>
					</div>
					<div class="col-4">
						<label class="form-label" for="prenom">Prénom : </label>
						<input class="form-control" type="text" id="prenom" name="prenom" value="<c:out value="${ employeAAfficher.prenom }"/>" required>
					</div>
					<div class="col-2">
						<label class="form-label" for="dateNaissance">Date de naissance : </label>
						<input class="form-control" type="date" id="dateNaissance" name="dateNaissance" value="<c:out value="${ employeAAfficher.dateNaissance }"/>" required>
					</div>
				</div>
			</fieldset>
			
			<fieldset class="container">
				<legend>Informations professionnelles</legend>
				<div class="row mt-3">
					<div class="col-2">
						<label class="form-label" for="dateEmbauche">Date d'embauche : </label>
						<input class="form-control" type="date" id="dateEmbauche" name="dateEmbauche" value="<c:out value="${ employeAAfficher.dateEmbauche }"/>" required>
					</div>
					<div class="col-7">
						<label class="form-label" for="fonction">Fonction : </label>
						<input class="form-control" type="text" id="fonction" name="fonction" value="<c:out value="${ employeAAfficher.fonction }"/>" required>
					</div>
					<div class="col-3">
						<label class="form-label" for="rendCompte">Rend compte : </label>
						<input class="form-control" type="text" id="rendCompte" name="rendCompte" value="<c:out value="${ employeAAfficher.rendCompte }"/>" required>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col">
						<label class="form-label" for="salaire">Salaire : </label>
						<input class="form-control" type="number" id="salaire" name="salaire" value="<c:out value="${ employeAAfficher.salaire }"/>" required>
					</div>
					<div class="col">
						<label class="form-label" for="commission">Commission : </label>
						<input class="form-control" type="number" id="commission" name="commission" value="<c:out value="${ employeAAfficher.commission }"/>" required>
					</div>
				</div>
			</fieldset>
			<div class="container mt-5">
				<button type="submit" class="btn btn-secondary offset-11 col-1" onclick="EmployeDao.modifier(<c:out value="${ employeAAfficher }"/>)">Modifier</button>
			</div>
		</form>
	</section>
</body>
</html>