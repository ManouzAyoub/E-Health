<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>User's selected information</title>
</head>
<body>
        <div id="corps">
            <p class="rs">${ form.getResultat() }</p>
            <p>Email : <c:out value="${ visiter.email }"/></p>
            <p>Mot de passe : <c:out value="${ visiter.password }"/></p>
        </div>

</body>
</html>