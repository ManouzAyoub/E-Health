
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>User's selected information</title>
</head>
<body>
        <div id="corps">
            <p class="rs">${ form.getResultat() }</p>
            <p>Email : <c:out value="${ visiter.email }"/></p>
            <p>Mot de passe : <c:out value="${ visiter.password }"/></p>
        </div>
        
        <form action="<%=request.getContextPath()%>/searchDoctor" method="get">
        	<c:set var="visiter" value="${visiter }" scope="session"></c:set>
        	<button type="submit">Search Doctors</button>
        </form>

</body>
</html>