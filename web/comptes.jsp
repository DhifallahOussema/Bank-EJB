<%@page import="tn.enis.entity.Compte"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comptes</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
</head>
<body>

	<div class="container">
	<div class = "row">
		<div class ="col-md-6"><h1>Accounts list</h1></div>
		<div class ="col-md-6" >
			<div class="d-flex flex-row-reverse">
				<div class="p-2">
				<a href="ClientController"><button class ="btn btn-primary" >Veiw Clients</button></a>
				</div>
				<div class="p-2">
				<a href="addAccount.jsp"><button class ="btn btn-primary" >Add Account</button></a>
				</div>
			</div>
		</div>
			
			
		</div>
	<%
	List<Compte> comptes = (List<Compte>) request.getAttribute("comptes");
	%>
	<table class="table">
		<tr>
			<th>RIB</th>
			<th>Client</th>
			<th>Solde</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		if (comptes != null && !comptes.isEmpty()) {
			for (Compte c : comptes) {
		%>
		<tr id="tr<%=c.getRib()%>">
			<td><%=c.getRib()%></td>
			<td><%=c.getClient().getCin()%></td>
			<td><%=c.getSolde()%></td>
			<td><a href="CompteController?action=prepareUpdate&rib=<%=c.getRib()%>"><button class ="btn btn-secondary">Edit</button></a></td>
			<td><a href="javascript:deleteAccount(<%=c.getRib()%>)"><button class ="btn btn-danger">Delete</button></a></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	</div>

	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
	<script src="js/compte.js"></script>
</body>
</html>