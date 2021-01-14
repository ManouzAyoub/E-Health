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
				    <td>${ entry.value.getName()}</td>
				    <td>${ entry.value.getAdresse()}</td>
			  	</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>