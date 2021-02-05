<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Visiter's selected information</title>
</head>
<body>
        <div id="corps">
            <p class="rs">${ form.getResultat() }</p>
            <p>Prénom : <c:out value="${docteur.firstname}"/></p>
            <p>Nom : <c:out value="${ docteur.lastname }"/></p>
            <p>Email : <c:out value="${ docteur.email }"/></p>
            <p>Tel : <c:out value="${ docteur.tel }"/></p>
            <p>Tel : <c:out value="${ docteur.speciality }"/></p>
            <c:forEach var="langue" items="${ docteur.getLangues() }">
            	<p>Tel : <c:out value="${ langue.getLangue() }"/></p> <br/>
            </c:forEach>
            <p>Tel : <c:out value="${ docteur.practice }"/></p>
			<%-- <div style="width:25%; height:25%"> <img src="${ docteur.id_scan }"/> </div> --%>  
			<img src="data:image/png;base64,${docteur.getBase64image()}"/>          
            
             <%-- <c:forEach items="${ doctor.id_scan }" var="imagename">
             <p>ID scan :</p>
			 <img src="${pageContext.request.contextPath}/afficherDoctor/${imagename}">
			</c:forEach> --%> 
           
        </div>

</body>
</html>