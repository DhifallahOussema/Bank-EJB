<%@page import="tn.enis.entity.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Clients</title>
</head>
<body>
	
	<div class = "container">
		<div class = "row">
		<div class ="col-md-6"><h1>Clients list</h1></div>
		<div class ="col-md-6" >
			<div class="d-flex flex-row-reverse">
				<div class="p-2">
					<a href="CompteController"><button class ="btn btn-primary" >Veiw Accounts</button></a>
				</div>
				<div class="p-2">
					<button class ="btn btn-primary" id="btnAdd" >Add Client</button>
				</div>
			</div>
		</div>
			
			
		</div>
	

	<%
	List<Client> clients = (List<Client>) request.getAttribute("clients");%>
	
	<table class = "table table ">
		<tr>
			<th>CIN</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Adresse</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		if (clients != null && !clients.isEmpty()) {
			int index = -1;
			for (Client c : clients) {
				index++;
		%>
		<tr id="tr<%=c.getCin()%>">
			<td><%=c.getCin()%></td>
			<td><%=c.getNom()%></td>
			<td><%=c.getPrenom()%></td>
			<td><%=c.getAdresse()%></td>
			<td><a href="javascript:editClient(<%=c.getCin()%>)"><button class="btn btn-secondary">Edit</button></a></td>
			<td><a href="javascript:deleteClient(<%=c.getCin()%>)"><button class="btn btn-danger">Delete</button></a></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	</div>

	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
	<script src="js/client.js"></script>
</body>
</html>