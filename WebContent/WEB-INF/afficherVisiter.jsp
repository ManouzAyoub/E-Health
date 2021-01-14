<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Visiter's selected information</title>
</head>
<body>
<p> do u see me</p>
        <div id="corps">
            <p class="rs">${ form.getResultat() }</p>
            <p>Prénom : <c:out value="${visiter.firstname}"/></p>
            <p>Nom : <c:out value="${ visiter.lastname }"/></p>
            <p>Email : <c:out value="${ visiter.email }"/></p>
            <p>Mot de passe : <c:out value="${ visiter.password }"/></p>
        </div>

</body>
</html>