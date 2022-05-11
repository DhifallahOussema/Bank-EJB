<%@page import="tn.enis.entity.Client"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Mise à jour de client</title>
</head>
<body>
	<h1>Update Client</h1>
	<%
	Client c = (Client) request.getAttribute("client");
	%>
	<div class="container">
		<form>
			<div class="row g-3 align-items-center">
				<div class="col-2">
					<label for="cin" class="col-form-label">Cin</label>
				</div>
				<div class="col-10">
					<input class="form-control" type="text" name="cin" id="cin"
						value="<%=c.getCin()%>">
				</div>
			</div>
			<div class="row g-3 align-items-center">
				<div class="col-2">
					<label for="nom" class="col-form-label">nom</label>
				</div>
				<div class="col-10">
					<input class="form-control" type="text" name="nom" id="nom"
						value="<%=c.getNom()%>">
				</div>
			</div>
			<div class="row g-3 align-items-center">
				<div class="col-2">
					<label for="prenom" class="col-form-label">prenom</label>
				</div>
				<div class="col-10">
					<input class="form-control" type="text" name="prenom" id="prenom"
						value="<%=c.getPrenom()%>">
				</div>
			</div>

			<div class="row g-3 align-items-center">
				<div class="col-2">
					<label for="adresse" class="col-form-label">adresse</label>
				</div>
				<div class="col-10">
					<input class="form-control" type="text" name="adresse" id="adresse"
						value="<%=c.getAdresse()%>">
				</div>
			</div>
			<input class="btn btn-primary" type="submit" name="action"
				value="update">
		</form>
	</div>

	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>