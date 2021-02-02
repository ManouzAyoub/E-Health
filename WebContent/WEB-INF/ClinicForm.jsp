<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form </title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="inc/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
     
    <link rel="stylesheet" href="inc/css/style.css"> 
    <style>     
     .hidden {
            display: none;
        }

        .visible {
            display: block;
        }

        .div {
            border: 1px solid #ebebeb;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 14px;
            font-weight: 500;
            color: #555;
            width: 100%;
            margin-bottom: 20px;
        }

        #sel {
            width: 100%;
        }

        .arrow {
            float: right;
            cursor: pointer;
        }
    </style>  
</head>
<body>

    <div class="main">

        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form action ="<%=request.getContextPath()%>/clinicForm" method="POST" id="signup-form" class="signup-form">
                        <h2 class="form-title">Create account</h2>
                        <div class="form-group">
                            <input type="text" class="form-input" name="name" id="name" placeholder="Your clinic's name" value="<c:out value="${requestScope.clinic.name}"/>" />
                            <span class="erreur" >${form.erreurs['name']}</span>      
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="address" id="address" placeholder="Your clinic's address" value="<c:out value="${requestScope.clinic.address}"/>" />
                            <span class="erreur" >${form.erreurs['adress']}</span>      
                        </div>
                        
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" id="email" placeholder="Your Clinic's Email" value="<c:out value="${requestScope.clinic.email}"/>" />
                             <span class="erreur" >${form.erreurs['email']}</span>  
                        </div>
                        
                        <div class="form-group">
                            <input type="tel" class="form-input" name="tel" id="tel" placeholder="Your clinic's number" value="<c:out value="${requestScope.clinic.tel}"/>" />
                             <span class="erreur" >${form.erreurs['tel']}</span>  
                        </div>
                        
                        <div class="form-group">
                            <input type="tel" class="form-input" name="emergency_tel" id="emergency_tel" placeholder="Your clinic's emergency number" value="<c:out value="${requestScope.clinic.emergency_tel}"/>" />
                             <span class="erreur" >${form.erreurs['emergency_tel']}</span>  
                        </div>
                      	

					<div class="div" onmouseover="showSelect('visible')" onmouseout="showSelect('hidden')">
				        &nbsp;&nbsp;&nbsp;&nbsp;Veuillez choisir votre/vos specialités <span class="arrow">&#9660;&nbsp;&nbsp;</span>
				
				        <select multiple="multiple" class="hidden" id="sel" name="speciality">
				            <option value="gynécologie et obstétrique">gynécologie et obstétrique</option>
				            <option value="gastro-entérologie">gastro-entérologie</option>
				            <option value="chirurgie esthétique">chirurgie esthétique</option>
				            <option value="Santé sexuelle et contraceptifs">Santé sexuelle et contraceptifs</option>
				            <option value="cardiologie">cardiologie</option>
				            <option value="anesthésiologie">anesthésiologie</option>
				            <option value="médecine intensive">médecine intensive</option>
				            <option value="médecine nucléaire">médecine nucléaire</option>
				            <option value="neurochirurgie">neurochirurgie</option>
				            <option value="oncologie médicale et chirurgicale">oncologie médicale et chirurgicale</option>
				            <option value="radiologie diagnostique et interventionnelle">radiologie diagnostique et interventionnelle</option>
				            <option value="neurochirurgie">neurochirurgie</option>
				            <option value="chirurgie orthopédique et traumatologique">chirurgie orthopédique et traumatologique</option>
				
				        </select>
				    </div>
                     
                        
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" onClick="checkTerms(event);" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="inc/terms.html" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"/>
                        </div>
                    </form>
                    <p class="loginhere">
                        Have already an account ? <a href="<c:url value="signIn" />" class="loginhere-link">Login here</a>
                    </p>
                </div>
            </div>
        </section>

    </div>
    <script src="inc/js/terms.js"></script>
    <script type="text/javascript">
    function showSelect(classname) {
        document.getElementById('sel').className = classname;
    }
    </script>
    <!-- JS -->
</body>
</html>