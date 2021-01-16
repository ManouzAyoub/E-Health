<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
			    <th>name</th>
			    <th>adresse</th>
		  	</tr>
		</thead>
		<tbody>
			<c:forEach var="entry" items="${c}">
				<tr>
					<td id="idProfil">${ entry.getIdProfil()}</td>
				    <td >${ entry.getName()}</td>
				    <td>${ entry.getAdresse()}</td>
				    <td>
				    	<a href="<c:url value="/navigation"> <c:param name="cabinet" value="${ entry }" /></c:url>">
				    		test
				    	</a>	
				    </td>
			  	</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		
	</script>
</body>
</html>