<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/demoIGE/style.css" rel="stylesheet">
<title>Liste employés</title>
</head>

<body>
	<%@ include file="header.jsp"%>
	<%@ include file="menu.jsp"%>
	
	<section id="listeEmployes">
		<h2>Liste des employés</h2>
		<table class="table table-hover">
			<tr>
				<th>No employé</th>
				<th>Prénom</th>
				<th>Nom</th>
				<th>Fonction</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${ employes }" var="employe">
				<tr>
					<td class="offset-1 col-2"><c:out value="${ employe.noEmploye }" /></td>
					<td class="col-2"><c:out value="${ employe.prenom }" /></td>
					<td class="col-2"><c:out value="${ employe.nom }" /></td>
					<td class="col-2"><c:out value="${ employe.fonction }" /></td>
					<td class="col-2"><a class="options" href="/demoIGE/employe/formulaire?noEmploye=<c:out value="${ employe.noEmploye }"/>" >Editer</a> / <a href="/demoIGE/employe/suppression?noEmploye=<c:out value="${ employe.noEmploye }"/>" class="options">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="message"><c:out value="${ employe.message }"/></div>
	</section>
</body>
</html>