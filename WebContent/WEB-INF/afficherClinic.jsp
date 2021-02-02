	
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
            <p>Email : <c:out value="${ clinic.email }"/></p>
            <p>Mot de passe : <c:out value="${ clinic.name }"/></p>
            <p>Mot de passe : <c:out value="${ clinic.speciality }"/></p>
        </div>

</body>
</html>