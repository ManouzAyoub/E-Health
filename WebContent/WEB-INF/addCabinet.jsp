<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ajouter Cabinet</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/addCabinet" method="post">
		<label>Name Cabinet:</label>
		<input type="text" name="name"/><br>
		<label>Adresse:</label>
		<input type="text" name="adresse"/><br>
		
		<button type="submit">Valider</button>
		<button type="reset"> Remettre à zéro</button>
	</form>
	<br>
	<br>
	<br>
	<table>
		<thead>
			<tr>
		    <th>id</th>
		    <th>name</th>
		    <th>adresse</th>
		  </tr>
		</thead>
		<tbody>
			<c:forEach var="entry" items="${cabinets}">
				<tr>
				    <td>${ entry.getIdProfil()}</td>
				    <td>${ entry.getName()}</td>
				    <td>${ entry.getAdresse()}</td>
				  </tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>