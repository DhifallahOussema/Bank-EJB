<%@page import="tn.enis.entity.Compte"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<title>Update Account</title>
</head>
<body>
	<div class ="container">
	<h1>Update Account</h1>
	<%
	Compte c = (Compte) request.getAttribute("compte");
	%>
	<div class="d-flex justify-content-center">
	<form action="CompteController" method="POST">
    <input type="hidden" name="rib" value="<%=c.getRib()%>">
    <div class="row g-3 align-items-center" style="margin-top: 5px;">
        <div class="col-2">
          <label for="cin" class="col-form-label">Solde</label>
        </div>
        <div class="col-10">
          <input class="form-control" type="text" name="solde" id="solde" value ="<%=c.getSolde()%>">
        </div>
    </div>
    <div class="row g-3 align-items-center" style="margin-top: 5px;">
        <div class="col-2">
          <label for="nom" class="col-form-label">Client</label>
        </div>
        <div class="col-10">
        <div class="ui-widget">
          <input class="form-control" type="text" name="client" id="client" value="<%=c.getClient().getCin()%>" autocomplete="off" >
        </div>
        </div>
        
    </div>
    <div class="row align-items-end" style="margin-top: 5px;">
    	<div class="col-9"></div>
	    <div  class="col-3">
	    	<button type ="submit" class="btn btn-primary" name = "action" value="update">Edit</button>    
	    </div>
    </div>
</form>
</div>
</div>

	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
	<script src="js/compte.js"></script>
</body>
</html>