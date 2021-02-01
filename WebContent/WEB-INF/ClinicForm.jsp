<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form </title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="inc/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
     
    <link rel="stylesheet" href="inc/css/style.css">
    <link rel="stylesheet" href="inc/css/youssef.css">
    
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
                      	
                      	<!-- début de changement -->
                        
						  <div class="form-group">     
					       <div class="selectBox" onClick="showCheckBoxes()">
					           <select id=""  class="form-input">
					               <option >Veuillez choisir les specialités de votre clinique</option>
					           </select>
					           <div class="overSelect"></div>
					           </div>
					           <div id="checkboxes" style="display:none">
					               <label for="sp1"><input type="checkbox" style="display:block"   id="sp1"/>gynécologie et obstétrique</label>
					           </div>
					    </div>
                     
                        
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"/>
                        </div>
                    </form>
                    <p class="loginhere">
                        Have already an account ? <a href="#" class="loginhere-link">Login here</a>
                    </p>
                </div>
            </div>
        </section>

    </div>
    <!-- var select = document.getElementById("selectchooser"); -->
        <script>
            var expanded =false;
            function showCheckBoxes(){
                var checkboxes = document.getElementById("checkboxes");
                if(!expanded){
                    checkboxes.style.display="block";
                    expanded=true;
                }else{
                    checkboxes.style.display="none";
                    expanded=false;
                }
            }
            
            
        </script>

    <!-- JS -->
<!--      <script src="vendor/jquery/jquery.min.js"></script>
 --></body>
</html>