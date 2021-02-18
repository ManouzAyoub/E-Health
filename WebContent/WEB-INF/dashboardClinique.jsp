<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<c:url value="/CliniqueDash/dashboard.css"/>">
      
        <style>
             .popup_section1 {
            filter:blur(8px);
            pointer-events:none;
            user-select:none;
            }
            
            #popup{
            position:fixed;
            top:40%;
            left:50%;
            transform:translate(-50%,-50%);
            width:700px;
            padding:50px;
            box-shadow:0 5px 30px rgba(0,0,0,.30);
            background:#fff;
            visibility:hidden; 
            opacity:0; 
            transition:0.5s;
            
            }
            
            #popup.active{
            top:50%;
            visibility:visible;
            opacity:1;
            transition:0.5s;
            }
            #popup > h2{
            text-align:center;
                    margin-bottom:40px;
            }
            .popup-buttons{
                            display:flex;
            justify-content:space-around;
            }
            .signup{
                height: 40px;
        width: 100px;
        border-radius: 5px;
        border: none;
        font-family:'Gilroy';
        font-weight: 500;
        font-size: 16px;
        filter: drop-shadow(3px 3px 3px #BCDAE8);
        outline: none;
        cursor: pointer;
        background-color: #27AAF0;
        opacity: 0.7;
        color: #EDF8FF ;}
        #popup .custom_select select{
            -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    outline: none;
    width: 100%;
    height: 100%;
    border: 0px;
    padding: 8px 10px;
    font-size: 15px;
    border: 1px solid #d5dbd9;
    border-radius: 3px;
        }
  
        </style>
</head>
<body>
    
    <input type="checkbox" id="nav-toggle">
    <div class="sidebar">
        <div class="sidebar-brand">
            <h2><span class="lab la-accusoft"></span> <span>E-Health</span></h2>
        </div>
        <div class="sidebar-menu">
            <ul>

                <!-- <li onClick="handleClick(event);show('DashboardSection')">
                    <aaaaaaaaaa id="dash" href="#"  class="buttons active" > -->

                <li  onClick="handleClick(event)">
                    <a id="dashboard"  href="#"  class="buttons active " onClick="handleClick(event)" >
                        
                        <span class="las la-igloo"></span>
                         <span>Dashboard</span>
                    </a>
                </li>
                <li  onClick="handleClick(event)">
                    <a id="docteur" href="#" class="buttons" onClick="handleClick(event);show('doctorsDash')" >
                        
                        <span class="las la-users"></span>
                          <span>Docteurs</span>
                    </a>
                </li>
                <li onClick="handleClick(event)">
                    <a id="commentaire" href="#" class="buttons" onClick="handleClick(event);show('commentsDash')">
                        <span class="las la-star"></span>
                         <span>Commentaires</span>
                    </a>
                </li>
               
              
                <li onClick="handleClick(event)">
                    <a id="compte" href="#" class="buttons" onClick="handleClick(event);show('InfoClinique')">
                        <span class="las la-user-circle"></span>
                         <span>Compte</span>
                    </a>
                </li>
              
            </ul>
        </div>
    </div>

    <div class="main-content">
        <header>
            <div class="header-title">
                <h2>
                    <label for="nav-toggle">
                        <span class="las la-bars"></span>
                    </label>
                    Dashboard
                </h2>
            </div>

            <div class="user-wrapper">
                <img src="./assets/img/plate1.png" width="40px" height="40px" alt="">
                <div class="user-wrapper-info">
                    <h4>${clinique.name}</h4>
                    <small>${clinique.adresse}</small>
                </div>
            </div>
        </header>

        <main class="dashboard" id="DashboardSection" >
            <div class="cards">
                <div class="card-single">
                    <div>
                        <h1>${nbrDoctors}</h1>
                        <span>Doctors</span>
                    </div>
                    <div>
                        <img src="https://img.icons8.com/ios/50/069c54/doctor-male.png" style="color:blue;"/>                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <h1>${nbrComments}</h1>
                        <span>Commentaires</span>
                    </div>
                    <div>
                        <img src="https://img.icons8.com/carbon-copy/60/069c54/clinic.png" style="color:blue;"/>
                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <h1>${nbrRating}</h1>
                        <span>Rating</span>
                    </div>
                    <div>
                        <img src="https://img.icons8.com/emoji/48/000000/star-emoji.png" style="color:blue;" />                    </div>
                </div>
            </div>

            <div class="recent-grid">
                <div class="projects">
                    <div class="card">
                        <div class="card-header">
                            <h3>Commantaires :</h3>
                            <button>See all <span class="las la-arrow-right"></span></button>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table width="100%">
                                    <thead>
                                        <tr>
                                            <td>Utilisateur</td>
                                            <td>Commentaire</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="entry" items="${comments}">
                                            <tr>
                                                <td>${entry.getUser().getFirstname()} ${entry.getUser().getLastname()}</td>                                               
                                                <td>
                                                    ${entry.commentaire}
                                                </td>
                                            </tr>
                                        </c:forEach>   
        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="customers">
                    <div class="card">
                        <div class="card-header">
                            <h3>Vos Docteurs :</h3>
                            <button>See all <span class="las la-arrow-right"></span></button>
                        </div>
                        <div class="card-body">
                            <c:forEach var="entry" items="${doctors}">
                                <div class="customer">
                                    <div class="info">
                                        <img src="./assets/img/plate1.png" width="40px" height="40px" alt="">
                                        <div>
                                            <h4>${entry.getUser().getFirstname()} ${entry.getUser().getLastname()}</h4>
                                            <small>Docteur</small>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                </div>
            </div>
        </main>

        <main class="commentaire hide" id="commentsDash" >
            <div class="recent-grid">
                <div class="projects">
                    <div class="card">
                        <div class="card-header">
                            <h3>Commantaires :</h3>
                            <button style="background-color:#E33A49;border:#E33A49;cursor:pointer;">Delete All  <span class="fas fa-trash"></span></button>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table width="100%" >
                                    <thead>
                                        <tr>
                                            <td>Utilisateur</td>
                                            <td>Commentaire</td>
                                            <td></td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="entry" items="${comments}">
                                            <tr>
                                                <td>${entry.getUser().getFirstname()} ${entry.getUser().getLastname()}</td>                                               
                                                <td>
                                                    ${entry.commentaire}
                                                </td>
                                                <td><a href="#"><span class="fas fa-trash"></span></a></td>
                                            </tr>
                                        </c:forEach>
        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
        </main>

        <main id="doctorsDash" class=" docteur hide" >
            <div class="recent-grid">
                <div class="projects">
                    <div class="card">
                        <div class="card-header">
                            <h3>Docteurs :</h3>
                            <div> <button class="ajouterDocteur" style="background-color:#27AAF0;border:#27AAF0;cursor:pointer;">Ajouter  <span class="fas fa-plus"></span></button>
                                <button style="background-color:#E33A49;border:#E33A49;cursor:pointer;">Supprimer tous  <span class="fas fa-trash"></span></button></div>
                           
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table width="100%">
                                    <thead>
                                        <tr>
                                            <td>Docteur</td>
                                            <td>Spécialité</td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="entry" items="${doctors}">
                                            <tr>
                                                <td>${entry.getUser().getFirstname()} ${entry.getUser().getLastname()}</td>
                                                <td>
                                                    ${entry.speciality}
                                                </td>
                                                <td><a href="#"><span class="fas fa-user"></span></a></td>
                                                <td><a href="#"><span class="fas fa-trash"></span></a></td>
                                                
                                            </tr>
                                        </c:forEach>
        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                
        </main>
        
        <div id="popup" >
            <h2>Vous souhaitez vous inscrire en tant que :</h2> 
            <div class="popup-buttons">
                <div class="custom_select">
                    <select name="speciality">
                    	<c:forEach var="specia" items="${Instances.specialities()}">
                    		<option value="${specia}" ${ clinique.speciality == specia ? 'selected' : '' } }>${specia}</option>
                    	</c:forEach>
                      
                    </select>
                  </div>
             <a href="#"><button class="signup"  >Utilisateur</button></a></div>
        </div>
        <!-- <main class="mainTag" id="ProfileSection" style="display: none;"> -->

        <main id="InfoClinique" class="compte hide" >
            <form method="POST" action="<c:url value="InformationClinique"></c:url>">
                <div class="wrapper" >
                    <div class="title">
                      Modifier vos Information :
                    </div>
                    <div class="form">
                       <div class="inputfield">
                          <label>Nom de la Clinique :</label>
                          <input type="text" name="nom" value="${clinique.name}" class="input">
                          <input type="hidden" name="id" value="${clinique.cin}" class="input">
                       </div>  
                       <div class="inputfield">
                        <label>Email Address</label>
                        <input type="text" name="email" value="${clinique.email}" class="input">
                     </div> 
                        <div class="inputfield">
                          <label>Adresse :</label>
                          <input type="text" name="adresse" value="${clinique.adresse}" class="input">
                       </div>  
                       <div class="inputfield">
                          <label>Téléphone :</label>
                          <input type="text" name="tel" value="${clinique.tel}" class="input">
                          
                       </div>  
                      <div class="inputfield">
                          <label>Description :</label>
                          <textarea class="input" name="desc" cols="30" rows="4">${clinique.description}</textarea>
                       </div> 
                       <div class="inputfield">
                        <label>Téléphone D'urgence :</label>
                        <input type="text" name="urgence" value="${clinique.emergency_tel}" class="input">
                        
                     </div> 
                        <div class="inputfield">
                          <label>Spécialité :</label>
                          <div class="custom_select">
                              <select name="speciality">
		                    	<c:forEach var="specia" items="${Instances.specialities()}">
		                    		<option value="${specia}" ${ clinique.speciality == specia ? 'selected' : '' } }>${specia}</option>
		                    	</c:forEach>
                   			 </select>
                          </div>
                       </div> 
                      <div class="inputfield">
                        <input type="submit" value="Enregistrer" class="btn">
                      </div>
                    </div>
                </div>
            </form>
        </main>

    </div>
    
    <script>
        var btn = document.getElementsByClassName('buttons');
        var mains = document.getElementsByTagName('main');
        var popupBtn = document.querySelector(".ajouterDocteur");
        var popup = document.querySelector("#popup");
        var blured = document.querySelector("#doctorsDash");

        popupBtn.addEventListener("click",function(){
            popup.classList.toggle("active");
            blured.classList.toggle("popup_section1");

        });
        blured.addEventListener("click",()=>{
            if(blured.classList.contains("popup_section1")){
              //  blured.classList.remove("popup_section1");
               // popup.classList.remove("active");
            }
        });
       

        function handleClick(event){
            if (event.target.parentElement.classList.contains('buttons')) {
                for(var i=0; i<btn.length; i++){
                    if(btn[i].classList.contains('active')){
                        btn[i].classList.remove('active');
                    }
                }
                event.target.parentElement.classList.add('active');  
            }
            console.log(document.querySelector("."+event.target.parentElement.id));
            if (document.querySelector("."+event.target.parentElement.id).classList.contains('hide'))
            {
                console.log(document.getElementsByClassName(event.target.parentElement.id));
                for  (var i=0 ; i<mains.length ; i++)
                {
                        mains[i].classList.add('hide'); 
                }
                document.querySelector("."+event.target.parentElement.id).classList.remove('hide');
            }
        }
        

        function show(param_div_id) {
            document.getElementById('main_place').innerHTML = document.getElementById(param_div_id).innerHTML;
        }
        
    </script>
</body>
</html>