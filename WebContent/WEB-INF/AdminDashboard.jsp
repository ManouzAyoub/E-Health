<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="./assets/css/dashboard.css" />" >
    <style>
    
    .card-profile {
    flex: 1 1 auto;
    min-height: 1px;
    padding: 1rem;
   }
    .profile_section_part1{
            display:grid;
            grid-template-columns: 200px auto;
    }
        .profile{
            display:grid;
            grid-row-gap:17px;
            grid-template-rows: 350px 1fr; 
        }
            .card-form{
            display: grid;
            grid-template-columns: auto;
            
          }
.day {
    height: 25px;
    margin:10px 7px 10px 0 ; 
    display: inline-block;
}
.from,.to{
    width: 60px;
    border-radius: 5px;
    margin-right:10px;
    }
    .day > select{
     cursor:pointer;
     border:1px solid #ccc;	
}

#label {
    float: left;
    min-width: 80px;
    width:100px;
}
}

    </style>
</head>
<body>
    <input type="checkbox" id="nav-toggle">

    <div class="sidebar">
        <div class="sidebar-brand">
            <h2><span class="lab la-accusoft"></span> <span>E-HEALTH</span></h2>
        </div>
        <div class="sidebar-menu">
            <ul>
            
                <li>
                    <a href="#" class="buttons active" onclick="handleClick(event);show('profile')">
                        
                    <img id="adm" src="https://img.icons8.com/windows/24/ffffff/change-user-male--v1.png" style="padding-right:12px"/>                        Admin Profile
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons" onclick="handleClick(event);show('dashboard')">
                        
                        <span class="las la-igloo"></span>
                        Dashboard
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash" onClick="handleClick(event);show('Demmandes')">
                        
                        <span class="las la-clipboard-list"></span>
                        Demands
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash" onClick="handleClick(event);show('pharmacy')">
                        
                        <img  id="phar" src="https://img.icons8.com/pastel-glyph/24/ffffff/hand-with-a-pill.png"  style="padding-right:12px"/>
                        Pharmacy
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash" onClick="handleClick(event);show('hospital')">
                        
                        <img id="hos" src="https://img.icons8.com/material/24/ffffff/hospital-2.png"  style="padding-right:12px"/>
                        Hospital
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons btn-comment"  onclick="handleClick(event);show('comments_Section')">
                        <span class="las la-user-circle"></span>
                        Comments
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
                <img src="<c:url value="./assets/img/unknown.png" />" width="40px" height="40px" alt="">
                <div class="user-wrapper-info">
                    <h4>${sessionScope.admin.firstname} ${sessionScope.admin.lastname}</h4>
                    <small>super admin</small>
                </div>
            </div>
        </header>
        <main>

            <!-- main_page -->
            <div id="main_place" style="margin-top: 40px;"></div>
            <!-- main_page -->
             
            <!-- demandes -->
            <div class="main-content" id="Demmandes" style="display:none;">
                <header>
                    <div class="header-title">
                        <h2>
                            <label for="nav-toggle">
                                <span class="las la-bars"></span>
                            </label>
                            Demmandes
                        </h2>
                    </div>
        
                    <div class="user-wrapper">
                        <img src="<c:url value="./assets/img/unknown.png" />" width="40px" height="40px" alt="">
                        <div class="user-wrapper-info">
                            <h4>${sessionScope.admin.firstname} ${sessionScope.admin.lastname}</h4>
                            <small>super admin</small>
                        </div>
                    </div>
                </header>
        
                <main>
        
                    <div class="demmande-grid">
        
                        <div class="Dommendes-card">
                            <div class="demmande_card">
                                <div class="card-header">
                                    <h3>Demmandes de comptes</h3>
                                </div>
                                <div class="demmande-card-body">
                                  <c:if test="${!docs.isEmpty()}">
                                    <c:forEach var="doc" items="${docs}" >
                                        <div class="Form">
                                            <div class="info">
                                                <div>
                                                    <h4>${doc.firstname} ${doc.lastname}</h4>
                                                    <small >Docteur</small>
                                                </div>
                                            </div>
                                            <div class="contact">
                                                <a href="<c:url value="/docsInfo?id=${doc.cin}" />" target="_blank" class="viewBtn">Voir la demmande</a>
                                            </div>
                                        </div>
                                      </c:forEach>
                                  </c:if>
                                  <c:if test="${!clinics.isEmpty()}">
                                    <c:forEach var="clinic" items="${clinics}">
                                        <div class="Form">
                                            <div class="info">
                                                <div>
                                                    <h4>${clinic.name}</h4>
                                                    <small>Clinique</small>
                                                </div>
                                            </div>
                                            <div class="contact">
                                                <a href="<c:url value="/clinicInfo?id=${clinic.cin}" />" class="viewBtn">Voir la demmande</a>
                                            </div>
                                        </div>
                                     </c:forEach>
                                  </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
           <!-- demandes -->
           
           <!-- profile -->
           <div  id="profile" style="display:none;">
           <div class="profile">
           <div class="profile_section_part1">
           <div class="card-profile" style="border:5px solid green;width:200px">
                  <div class="d-flex flex-column align-items-center text-center">
                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                    <div class="mt-3">
                      <h4>Youssef El gourrari</h4>
                      <p class="text-secondary mb-1">backend Developer</p>
                      <p class="text-muted font-size-sm">Agadir,salam</p>
                    </div>
                  </div>
                </div>
    
           <div class="card-profile">
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Full Name</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      Youssef El gourrari
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Email</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      youssef@gmail.com
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Phone</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      06154214854
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Role</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      Backend developer
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Address</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      Agadir,salam
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Password</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      ysf123@
                    </div>
                  </div>
                </div>
           </div>
           <div class="card-form">
                          <form>
                              <div class="form-group">
                                <label for="inputName">Name</label>
                                <input type="text" class="form-control" id="inputName" placeholder="Name">
                              </div>
                                <div class="form-group">
                                <label for="inputLastName">Last Name</label>
                                <input type="text" class="form-control" id="inputLastName" placeholder="Last Name">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                              </div>
                                <div class="form-group">
                                <label for="exampleInputEmail1">Phone</label>
                                <input type="text" class="form-control" id="exampleInputPhone" placeholder="Phone Number">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputEmail1">Role</label>
                                <input type="text" class="form-control" id="exampleInputRole" placeholder="Role">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputFile">File input</label>
                                <input type="file" id="exampleInputFile">
                              </div>
                              <button type="submit">Submit</button>
                            </form>    
                       </div>
                </div>     
           </div>
           <!-- profile -->
           
           <!-- pharmacie -->
           <div id="pharmacy" style="display:none;">
               <div class="card-form-pharmacy">
                      <form>
                              <div class="form-group">
                                <label for="inputName">Name</label>
                                <input type="text" class="form-control" id="inputName" placeholder="Name">
                              </div>
                                <div class="form-group">
                                <label for="inputLastName">Address</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="Address">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputEmail1">Email</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                              </div>
                               <div class="form-group">
                                <label for="exampleInputEmail1">Email</label>
                                <input type="tel" class="form-control" id="exampleInputTel" placeholder="Tel">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputPassword1">Location ID</label>
                                <input type="text" class="form-control" id="exampleInputID" placeholder="LocationID">
                              </div>
                              
                      <div class="working_hours"> 
                          <label>Check your opening hours</label>
                           <div id="hourForm" class="hourForm">
							    <div id="Sunday" class="day"></div>
							    <div id="Monday" class="day"></div>
							    <div id="Tuesday" class="day"></div>
							    <div id="Wednesday" class="day"></div>
							    <div id="Thursday" class="day"></div>
							    <div id="Friday" class="day"></div>
							    <div id="Saturday" class="day"></div>
                         </div> 
                     </div>
                              <button type="submit">Submit</button>
                            </form>    
    </div>
           </div>
           <!-- pharmacie -->
           
           <!-- hospital -->
           <div id="hospital" style="display:none;">
                        <form>
                              <div class="form-group">
                                <label for="inputName">Name</label>
                                <input type="text" class="form-control" id="inputName" placeholder="Name">
                              </div>
                                <div class="form-group">
                                <label for="inputLastName">Address</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="Address">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputEmail1">Email</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                              </div>
                               <div class="form-group">
                                <label for="exampleInputEmail1">Email</label>
                                <input type="tel" class="form-control" id="exampleInputTel" placeholder="Tel">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputPassword1">Location ID</label>
                                <input type="text" class="form-control" id="exampleInputID" placeholder="LocationID">
                              </div>
                               <button type="submit">Submit</button>
                            </form>
           </div>
           <!-- hospital -->

            <!-- comment section -->
            <div class="commentsSection" id="comments_Section" style="display:none;">
                <div class="recent-grid-comments">
                    <div class="projects">
                        <div class="card">
                            <div class="card-header">
                                <h3>Comments</h3>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table width="100%">
                                        <thead>
                                            <tr>
                                                <td>Username</td>
                                                <td>Commented on</td>
                                                <td>Etablissement's name</td>
                                                <td>Comment</td>
                                                <td>Delete</td>
                                                <td>Approve</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            
                                            <c:forEach var="entry" items="${comments}">
                                                <tr>
                                                    <td> ${entry.getUser().getFirstname()} ${entry.getUser().getLastname()}</td>
                                                    <c:if test="${entry.getDocteur() != null}">
                                                        <td>Doctor</td>
                                                        <td>${entry.getDocteur().getFirstname()} ${ entry.getDocteur().getLastname() }</td>
                                                    </c:if>
                                                    <c:if test="${entry.getClinique() != null}">
                                                        <td>Doctor</td>
                                                        <td>${entry.getClinique().getName()} </td>
                                                    </c:if>
                                                    <c:if test="${entry.getHopital() != null}">
                                                        <td>Doctor</td>
                                                        <td>${entry.getHopital().getName()} </td>
                                                    </c:if>
                                                    <td>
                                                        <span class="status orange"></span>
                                                        ${entry.commentaire}
                                                    </td>
                                                    <td>
                                                        <a class="delete" href="<c:url value="/GestionComment"><c:param name = "dlte" value = "${entry.idCommentaire}"/></c:url>">
                                                            <img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />
                                                            &nbsp;delete
                                                        </a>
                                                    </td>
                                                    <td>
                                                        <a class="approve" href="<c:url value="/GestionComment"><c:param name = "apprv" value = "${entry.idCommentaire}"/></c:url>">
                                                            
                                                            <img src="https://img.icons8.com/metro/14/ffffff/approve.png"/>
                                                            &nbsp;approve
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>    
            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- comment section -->

            <!-- Dashboard -->
            <div id="dashboard"  class="dash_grid" style="display:none;">
            <div class="cards">
                <div class="card-single">
                    <div>
                        <h1>${nbrUsers}</h1>
                        <span>Users</span>
                    </div>
                    <div>
                        <span class="las la-users">
    
                        </span>
                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <h1>${nbrDoctors}</h1>
                        <span>Doctors</span>
                    </div>
                    <div>
                        <img src="https://img.icons8.com/ios/50/069c54/doctor-male.png"/>                    
                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <h1>${nbrClinics}</h1>
                        <span>Clinics</span>
                    </div>
                    <div>
                        <img src="https://img.icons8.com/carbon-copy/60/069c54/clinic.png"/>
                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <h1>${nbrPharmacies}</h1>
                        <span>Pharmacies</span>
                    </div>
                    <div>
                        <img src="https://img.icons8.com/pastel-glyph/60/069c54/hand-with-a-pill.png"/>
                    </div>
                </div>
            </div>
            <div  class="recent-grid" >
                <div class="projects">
                    <div class="card">
                        <div class="card-header">
                            <h3>Comments</h3>
                            <button onclick="show('comments_Section')">See all <span class="las la-arrow-right"></span></button>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table width="100%">
                                    <thead>
                                        <tr>
                                            <td>Username</td>
                                            <td>Commented on</td>
                                            <td>Etablissement's name</td>
                                            <td>Comment</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <c:forEach var="entry" items="${comments}">
                                            <tr>
                                                <td> ${entry.getUser().getFirstname()} ${entry.getUser().getLastname()}</td>
                                                <c:if test="${entry.getDocteur() != null}">
                                                    <td>Doctor</td>
                                                    <td>${entry.getDocteur().getFirstname()} ${ entry.getDocteur().getLastname() }</td>
                                                </c:if>
                                                <c:if test="${entry.getClinique() != null}">
                                                    <td>Doctor</td>
                                                    <td>${entry.getClinique().getName()} </td>
                                                </c:if>
                                                <c:if test="${entry.getHopital() != null}">
                                                    <td>Doctor</td>
                                                    <td>${entry.getHopital().getName()} </td>
                                                </c:if>
                                                <td>
                                                    <span class="status orange"></span>
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
                            <h3>New doctors waiting </br> be approved</h3>
                            <button onclick="document.getElementsByName('btn-comment')[0].classList.add('active')">See all <span class="las la-arrow-right"></span></button>
                        </div>
                        <div class="card-body">
                            <c:if test="${ !docs.isEmpty() }">
                            	<c:forEach var="docteur" items="${docs}">
	                                <div class="customer">
	                                    <div class="info">
	                                        <img src="./assets/img/doc.jpg" width="40px" height="40px" alt="">
	                                        <div>
	                                            <h4>${docteur.firstname} ${docteur.lastname}</h4>
	                                            <small>cabinet médical</small>
	                                        </div>
	                                    </div>
	                                </div>
	                            </c:forEach>
                            </c:if>
                            <c:if test="${ !clinics.isEmpty() }">
                            	<c:forEach var="clinic" items="${clinics }">
	                                <div class="customer">
	                                    <div class="info">
	                                        <img src="./assets/img/unknown.png" width="40px" height="40px" alt="">
	                                        <div>
	                                            <h4>${clinic.name}</h4>
	                                            <small>clinique</small>
	                                        </div>
	                                    </div>
	                                </div>
                            </c:forEach>
                            </c:if>
                        </div>
                </div>
            </div>
        </div>
            <!-- Dashboard -->

        </main>
    </div>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="inc/js/schedule.js"></script>
    <script>
        var btn = document.getElementsByClassName('buttons');
        function handleClick(event){
            if (event.target.classList.contains('buttons')) {
                for(var i=0; i<btn.length; i++){
                    if(btn[i].classList.contains('active')){
                        btn[i].classList.remove('active');
                    }
                }
                event.target.classList.add('active');   
            }
        }

        function clickSpan(event){
            var btn = document.getElementsByClassName('spans');
        }

        function showComments(){
            document.getElementsByClassName("recent-grid")[0].style.display="none";
            document.getElementsByClassName("commentsSection")[0].style.display="block";

        }
        function show(param_div_id) {
    document.getElementById('main_place').innerHTML = document.getElementById(param_div_id).innerHTML;
  }

    </script>
</body>
</html>