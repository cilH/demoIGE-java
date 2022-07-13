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
<title>Suppression employé</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="menu.jsp"%>

<section id="suppression">
	<h2>Suppression employé</h2>
		<form action="" method="post" class="row g-3">

			<div class="row">
				<div class="col-2">
					<label class="form-label" for="noEmploye">No de l'employé : </label>
					<input class="form-control" type="number" id="noEmploye" name="noEmploye" value="<c:out value="${ employeASupprimer.noEmploye }"/>" readonly>
				</div>
			</div>
			
			<fieldset class="container">
				<legend>Informations personnelles</legend>
				<div class="row mb-3">
					<div class="col-2">
						<label class="form-label" for="titre">Titre : </label>
						<input class="form-control" type="text" id="titre" name="titre" value="<c:out value="${ employeASupprimer.titre }"/>" readonly>
					</div>
					<div class="col-4">
						<label class="form-label" for="nom">Nom : </label>
						<input class="form-control" type="text" id="nom" name="nom" value="<c:out value="${ employeASupprimer.nom }"/>" readonly>
					</div>
					<div class="col-4">
						<label class="form-label" for="prenom">Prénom : </label>
						<input class="form-control" type="text" id="prenom" name="prenom" value="<c:out value="${ employeASupprimer.prenom }"/>" readonly>
					</div>
					<div class="col-2">
						<label class="form-label" for="dateNaissance">Date de naissance : </label>
						<input class="form-control" type="date" id="dateNaissance" name="dateNaissance" value="<c:out value="${ employeASupprimer.dateNaissance }"/>" readonly>
					</div>
				</div>
			</fieldset>
			
			<div class="container mt-5">
			Êtes-vous certain de vouloir supprimer l'employé <c:out value="${ employeASupprimer.noEmploye }"/> ?
				<button type="submit" class="btn btn-secondary offset-11 col-1">Supprimer</button>
			</div>
		</form>
	</section>
</body>
</html>