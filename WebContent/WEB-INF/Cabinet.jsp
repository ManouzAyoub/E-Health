<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="commentaireForm" method="post">
		<textarea rows="3" cols="30" name="comments"></textarea>
		<button type="submit">Envoyer</button>
		<button type="reset">Remmettre a zéro</button>
	</form>
	
	<br><br><br>
	
	<c:forEach var="entry" items="${lescommentaires}">
		<label> ${entry} </label><br>
	</c:forEach>
	
</body>
</html>