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
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/css/bootstrap-select.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/0.8.2/css/flag-icon.min.css'>

    <link rel="stylesheet" href="inc/css/style.css">
</head>
<body>

    <div class="main">

        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form action ="<%=request.getContextPath()%>/doctorForm" method="POST" id="signup-form" class="signup-form" enctype="multipart/form-data" >
          	                        <h2 class="form-title">Create account</h2>
          	
                        <div class="form-group">
                            <input type="text" class="form-input" name="firstname" id="name" placeholder="Votre pr�nom" value="<c:out value="${requestScope.doctor.firstname}"/>" />
                            <span class="erreur" >${form.erreurs['firstname']}</span>      
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="lastname" id="name" placeholder="Votre nom" value="<c:out value="${requestScope.doctor.lastname}"/>" />
                            <span class="erreur" >${form.erreurs['lastname']}</span>      
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" id="email" placeholder="Votre email" value="<c:out value="${requestScope.doctor.email}"/>" />
                             <span class="erreur" >${form.erreurs['email']}</span>  
                        </div>
                        <div class="form-group">
                            <input type="tel" class="form-input" name="tel" id="tel" placeholder="Votre numero de telephone" value="<c:out value="${requestScope.doctor.tel}"/>" />
                             <span class="erreur" >${form.erreurs['tel']}</span>  
                        </div>
                        
                        <!-- languages -->
           		       
                             <select name="languages" class="selectpicker" style="margin:10px 0" data-width="fit"  multiple>
                         <option  data-content='<span class="flag-icon flag-icon-us"></span> English'>English</option>
                         <option  data-content='<span class="flag-icon flag-icon-mx"></span> Espa�ol'>Espa�ol</option>
                         <option  data-content='<span class="flag-icon flag-icon-cn"></span> Chinois'>Chinois</option>
                         <option  data-content='<span class="flag-icon flag-icon-fr"></span> Frensh'>Frensh</option>
                         <option  data-content='<span class="flag-icon flag-icon-ma"></span> Arabic'>Arabic</option>
                            </select>
                        
                        <!-- languages -->
                        
                                                
                        <!-- file CN -->
                         <div class="form-group" id="upload-container">
                        <label class="label-file">Merci de d�poser une photocopie de votre carte nationale :</label>
                        <div  id="upload-border">
                          <nobr>
                            <input type="text" id="upload-name1"   disabled="true" />
                            <label id="upload-button1">Cliquez moi!</label>
                          </nobr>
                        </div>
                        <input name="id_scan" type="file" id="hidden-upload1" style="display:none" multiple/>
                      </div>
                      <!-- file CN -->
                      
                      
                      <!-- file MED_certificate -->
                       
                        <div class="form-group" id="upload-container">
                        <label class="label-file">Merci de d�poser votre certificat m�dicale :</label>
                        <div  id="upload-border">
                          <nobr>
                            <input type="text" id="upload-name2"   disabled="true" />
                            <label id="upload-button2">Cliquez moi!</label>
                          </nobr>
                        </div>
                        <input name="med_certificate" type="file" id="hidden-upload2" style="display:none"/>
                      </div>
                      <!-- file MED_certificate -->
                      
                      <!-- file Profile_picture -->
                      
                         <div class="form-group" id="upload-container">
                          	<label class="label-file">Merci de d�poser votre photo de profile :</label>
	                        <div  id="upload-border">
	                          <nobr>
	                            <input type="text" id="upload-name3"   disabled="true" />
	                            <label id="upload-button3">Cliquez moi!</label>
	                          </nobr>
	                        </div>
                        	<input name="profile_image" type="file" id="hidden-upload3" style="display:none"/>
                      </div>
                      <!-- file Profile_picture -->
                      
                      <!-- file Local_contract -->
                      
                         <div class="form-group" id="upload-container">
	                        <label class="label-file">Merci de d�poser le contract de location de votre cabinet m�dical :</label>
	                        <div  id="upload-border">
	                          <nobr>
	                            <input type="text" id="upload-name4"   disabled="true" />
	                            <label id="upload-button4">Cliquez moi!</label>
	                          </nobr>
	                        </div>
	                        <input name="local_contract" type="file" id="hidden-upload4" style="display:none" />
                      </div>
                     <!-- file Local_contract -->
                      
                      <!-- select  -->                      
                        
                        <div class="form-group" style="margin-top:15px; margin-bottom:40px">
                        <select  name="med_practice" class="select-css" name="work">
                            <option>cabinet m�dical</option>
                            <option>pharmacie</option>
                            <option>clinique</option>
                        </select>
                        </div>
                        
                        <div class="form-group">
                        <select name="speciality" class="select-css" onmousedown="if(this.options.length>8){this.size=8;}"  onchange='this.size=0;' onblur="this.size=0;">
                            <option>chirurgie esth�tique</option>
                            <option>chirurgie p�diatrique</option>
                            <option>chirurgie vasculaire</option>
                            <option>chirurgie visc�rale et digestive</option>
                            <option>gyn�cologie obst�trique</option>
                            <option>neurochirurgie </option>
                            <option>allergologie</option>
                            <option>anatomie et cytologie pathologique</option>
                            <option>anesth�sie</option>
                            <option>cardiologie</option>
                            <option>dermatologie</option>
                            <option>endocrinologie-nutrition</option>
                            <option>g�n�tique</option>
                            <option>allergologie</option>
                            <option>gyn�cologie m�dicale</option>
                            <option>h�matologie</option>
                            <option>m�decine g�n�rale</option>
                            <option>m�decine physique et r�adaptation</option>
                            <option>n�phrologie</option>
                            <option>neurologie</option>
                            <option>psychiatrie</option>
                            <option>radiologie</option>
                            <option>r�animation</option>
                            <option>sant� publique</option>
                            <option>urgentiste</option>
                        </select>
                        </div>
                        <!-- select  -->
                        
                        
                        <div class="form-group">
                            <input type="checkbox" class="form-input" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="inc/terms.html" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up" onClick="postLogin(event);" />
                        </div>
                    </form>
                    <p class="loginhere">
                        Have already an account ? <a href="#" class="loginhere-link">Login here</a>
                    </p>
                </div>
            </div>
        </section>

    </div>
    <!-- JS -->
        <script>
    function postLogin(event) {
        var form = document.getElementById("signup-form");
        form.submit();

        event.preventDefault();
    }
    </script>

     <!-- <script src="inc/js/main.js"></script> -->
     <script src="inc/js/files.js"></script>
   
        <!--language js -->
      <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.2/jquery.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/js/bootstrap-select.min.js'></script>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
    <script  src="inc/js/languages.js"></script>
    <!-- languages -->
    
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- JS -->
    
</body>
</html>