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
    <!-- toggle button -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- toggle button -->
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
                    <a href="#" class="buttons dash" onclick="handleClick(event);show('profile')">
                        
                    <img id="adm" src="https://img.icons8.com/windows/24/ffffff/change-user-male--v1.png" style="padding-right:12px"/>
                    <span>Admin Profile</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons active" onclick="handleClick(event);show('dashboard')">
                        
                        <span class="las la-igloo"></span>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash" onClick="handleClick(event);show('Demmandes')">
                        
                        <span class="las la-clipboard-list"></span>
                        <span>Demands</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash" onClick="handleClick(event);show('pharmacy')">
                        
                        <img  id="phar" src="https://img.icons8.com/pastel-glyph/24/ffffff/hand-with-a-pill.png"  style="padding-right:12px"/>
                        <span>Pharmacy</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash" onClick="handleClick(event);show('hospital')">
                        
                        <img id="hos" src="https://img.icons8.com/material/24/ffffff/hospital-2.png"  style="padding-right:12px"/>
                        <span>Hospital</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons btn-comment"  onclick="handleClick(event);show('comments_Section')">
                        <img id="cmt" src="https://img.icons8.com/metro/24/ffffff/comments.png" style="padding-right:12px"/>
                        <span>Comments</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash"  onclick="handleClick(event);show('doctors_Section')">
                        <span class="las la-user-circle"></span>
                        <span>List of profile doctors</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash"  onclick="handleClick(event);show('cliniques_Section')">
                        <span class="las la-user-circle"></span>
                        <span>List of profile clinics</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash"  onclick="handleClick(event);show('pharmacies_Section')">
                        <span class="las la-user-circle"></span>
                        <span>List of profile pharmacies</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash"  onclick="handleClick(event);show('hospitals_Section')">
                        <span class="las la-user-circle"></span>
                        <span>List of profile hospitals</span>
                    </a>
                </li>
                <br>
                <li>
                    <a href="<c:url value="Deconnexion"></c:url>" class="buttons dash"  onclick="handleClick(event)">
                        <span class="las la-user-circle"></span>
                        <span>Déconnexion</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="main-content">
        <header>
            <div class="header-title" style="float:left">
                <h2>
                    <label for="nav-toggle">
                        <span class="las la-bars"></span>
                    </label>
                    Dashboard
                </h2>
            </div>

            <div class="user-wrapper" style="float:right">
                <img src="https://bootdey.com/img/Content/avatar/avatar7.png" width="40px" height="40px" alt="">
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
                                  <c:if test="${clinics.isEmpty() && docs.isEmpty()}">
                                    <div class="Form">
                                        <div class="info">
                                            <div>
                                                <h4>aucun clinique / docteur a approver</h4>
                                            </div>
                                        </div>
                                    </div>
                                  </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
           <!-- demandes -->
           
           <!-- profile -->
           <div  id="profile"  style="display:none;">
           <div class="profile">
           <div class="profile_section_part1">
           <div class="card-profile" style="border:5px solid green;width:200px;height: 300px;">
                <div class="d-flex flex-column align-items-center text-center">
                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                    <div class="mt-3">
                        <h4> ${sessionScope.admin.firstname} ${sessionScope.admin.lastname}</h4>
                        <p class="text-secondary mb-1">super admin</p>
                        <!-- <p class="text-muted font-size-sm">Agadir,salam</p> -->
                    </div>
                </div>
            </div>
    
           <div class="card-profile">
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Full Name</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                        ${sessionScope.admin.firstname} ${sessionScope.admin.lastname}
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Email</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                        ${sessionScope.admin.email}
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Phone</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                        ${sessionScope.admin.tel}
                    </div>
                  </div>
                  <hr>
                  <div class="row">
                    <div class="col-sm-3">
                      <h6 class="mb-0">Role</h6>
                    </div>
                    <div class="col-sm-9 text-secondary">
                      Administrateur
                    </div>
                  </div>
                </div>
           </div>
           <div class="card-form">
                          <form method="POST" action="<c:url value="/AdminProfile"></c:url>">
                              <div class="form-group" style="display: none;">
                                <label for="exampleInputEmail1">ID</label>
                                <input type="text" name="id" value="${sessionScope.admin.cin}" class="form-control" id="exampleInputEmail1" placeholder="id">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" name="email" value="${sessionScope.admin.email}" class="form-control" id="exampleInputEmail1" placeholder="Email">
                              </div>
                                <div class="form-group">
                                <label for="exampleInputEmail1">Phone</label>
                                <input type="text" name="tel" value="${sessionScope.admin.tel}" class="form-control" id="exampleInputPhone" placeholder="Phone Number">
                              </div>
                              <div class="form-group">
                                <label for="ancien">Ancien mot de pass</label>
                                <input type="password" name="acien_pass" class="form-control" id="ancien" placeholder="Ancien mot de pass">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputPassword1">Nouveau Password</label>
                                <input type="password" name="nv_pass" class="form-control" id="exampleInputPassword1" placeholder="Password">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputPassword2">Confirmation password</label>
                                <input type="password" name="confirmation_password" class="form-control" id="exampleInputPassword2" placeholder="Password">
                              </div>
                              <button type="submit">Submit</button>
                            </form>    
                       </div>
                </div>     
           </div>
           <!-- profile -->
           
           <!-- pharmacie -->
           <div id="pharmacy" class="recent-grid-comments" style="display:none;">
            
                <div class="projects">
                    <div class="card">
                        <div class="card-header">
                            <h3>Ajouter un nouveau pharmacie</h3>
                        </div>
                        <div style="padding: 1rem;">
                            <div class="table-responsive">
                                <form  method="POST" action="<c:url value="/PharmacieForm" ></c:url>">
                                    <div class="form-group">
                                        <label for="inputName">Name</label>
                                        <input type="text" name="name" class="form-control" id="inputName" placeholder="Name">
                                    </div>
                                    <div class="form-group">
                                        <label for="inpulVille">Ville</label>
                                        <input type="text" name="ville"  class="form-control" id="inpulVille" placeholder="Ville">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputLastName">Address</label>
                                        <input type="text" name="adresse"  class="form-control" id="inputAddress" placeholder="Address">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Email</label>
                                        <input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Phone</label>
                                        <input type="tel" name="tel" class="form-control" id="exampleInputTel" placeholder="Tel">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Location ID</label>
                                        <input type="text" name="id" class="form-control" id="exampleInputID" placeholder="LocationID">
                                    </div>
                        
                                      <button type="submit">Submit</button>
                                    </form>
                            </div>
                        </div>
                    </div>
                </div>
           </div>
           <!-- pharmacie -->
           
           <!-- hospital -->
           <diva id="hospital" style="display:none;">
                <div class="projects">
                    <div class="card">
                        <div class="card-header">
                            <h3>Ajouter un nouveau hopital</h3>
                        </div>
                        <div style="padding: 1rem;">
                            <div class="table-responsive">
                                <form method="POST" action="<c:url value="/HospitalForm" ></c:url>">
                                    <div class="form-group">
                                        <label for="inputName">Name</label>
                                        <input type="text" name="name" class="form-control" id="inputName" placeholder="Name">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Email</label>
                                        <input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputVille">Ville</label>
                                        <input type="text" name="ville" class="form-control" id="inputVille" placeholder="Ville">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputAddress">Address</label>
                                        <input type="text" name="adresse" class="form-control" id="inputAddress" placeholder="Address">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputTel">Phone</label>
                                        <input type="tel" name="tel" class="form-control" id="exampleInputTel" placeholder="Tel">
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputID">Location ID</label>
                                        <input type="text" name="id" class="form-control" id="exampleInputID" placeholder="LocationID">
                                    </div>
                                       <button type="submit">Submit</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                        
           </diva>
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
                                            <c:if test="${!comments.isEmpty()}">
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
                                                            <a class="btn btn-danger " href="<c:url value="/GestionComment"><c:param name = "dlte" value = "${entry.idCommentaire}"/></c:url>">
                                                                <img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />
                                                                &nbsp;delete
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a class="btn btn-success " href="<c:url value="/GestionComment"><c:param name = "apprv" value = "${entry.idCommentaire}"/></c:url>">
                                                                <img src="https://img.icons8.com/metro/14/ffffff/approve.png"/>
                                                                &nbsp;approve
                                                            </a>
                                                        </td>
                                                    </tr>
                                                
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${comments.isEmpty()}">
                                                <tr>
                                                    <td colspan="5"> aucun commentaire  -- modifier le text</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- comment section -->

            <!-- list doctor section -->
            <div id="doctors_Section" style="display:none;">
                <div class="recent-grid-comments">
                    <div class="projects">
                        <div class="card">
                            <div class="card-header">
                                <h3>List des docteurs</h3>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table width="100%">
                                        <thead>
                                            <tr>
                                                <td>Username</td>
                                                <td>Speciality</td>
                                                <td>ville</td>
                                                <td>Delete</td>
                                                <td>show profile</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:if test="${!allDoctors.isEmpty()}">
                                                <c:forEach var="entry" items="${allDoctors}">
                                                    <tr>
                                                        <td> ${entry.getFirstname()} ${entry.getLastname()}</td>
                                                        <td>${entry.getSpeciality()}</td>
                                                        <td>${entry.getVille()} </td>
                                                        <td>
                                                            <a class="btn btn-danger " href="<c:url value="/admin"><c:param name = "dlte" value = "${entry.cin}"/></c:url>">
                                                                <img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />
                                                                &nbsp;delete
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a class="btn btn-success " href="<c:url value="/admin"><c:param name = "show" value = "${entry.cin}"/></c:url>">
                                                                <img src="https://img.icons8.com/metro/14/ffffff/approve.png"/>
                                                                &nbsp;show profile
                                                            </a>
                                                        </td>
                                                    </tr>
                                                
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${allDoctors == null}">
                                                <tr>
                                                    <td colspan="5">AUCUN DOCTEUR</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- !list docteur section -->

            <!-- list cliniques section -->
            <div id="cliniques_Section" style="display:none;">
                <div class="recent-grid-comments">
                    <div class="projects">
                        <div class="card">
                            <div class="card-header">
                                <h3>List des cliniques</h3>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table width="100%">
                                        <thead>
                                            <tr>
                                                <td>Name</td>
                                                <td>Speciality</td>
                                                <td>ville</td>
                                                <td>Delete</td>
                                                <td>show profile</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:if test="${!allCliniques.isEmpty()}">
                                                <c:forEach var="entry" items="${allCliniques}">
                                                    <tr>
                                                        <td> ${entry.name}</td>
                                                        <td>${entry.speciality}</td>
                                                        <td>${entry.getVille()} </td>
                                                        <td>
                                                            <a class="btn btn-danger " href="<c:url value="/admin"><c:param name = "dlte_clinique" value = "${entry.cin}"/></c:url>">
                                                                <img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />
                                                                &nbsp;delete
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a class="btn btn-success " href="<c:url value="/admin"><c:param name = "show_clinique" value = "${entry.cin}"/></c:url>">
                                                                <img src="https://img.icons8.com/metro/14/ffffff/approve.png"/>
                                                                &nbsp;show profile
                                                            </a>
                                                        </td>
                                                    </tr>
                                                
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${allCliniques == null}">
                                                <tr>
                                                    <td colspan="5">AUCUN CLINIQUE</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- !list cliniques section -->

            <!-- List Pharmacies section -->
            <div id="pharmacies_Section" style="display:none;">
                <div class="recent-grid-comments">
                    <div class="projects">
                        <div class="card">
                            <div class="card-header">
                                <h3>List des pharmacies</h3>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table width="100%">
                                        <thead>
                                            <tr>
                                                <td>Name</td>
                                                <td>telephone</td>
                                                <td>ville</td>
                                                <td>en garde</td>
                                                <td>Delete</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:if test="${!allPharmacies.isEmpty()}">
                                                <c:forEach var="entry" items="${allPharmacies}">
                                                    <tr>
                                                        <td> ${entry.name}</td>
                                                        <td>${entry.tel}</td>
                                                        <td>${entry.getVille()} </td>
                                                        <td>
                                                        <form method="POST" action="<c:url value="ToggleGarde"></c:url>" >
                                                          
                                                           <div class="custom-control custom-switch" >
                                                               <c:set var="checked" value="chekeded"></c:set>
                                                               <c:set var="id" value="${entry.idPharmacie}"></c:set>
                                                               <c:if test="${pharmacieDao.getById(id).getEn_garde() == true}">
                                                                    <input type="checkbox"  name="checkgarde"  onchange="toggleGarde('${entry.idPharmacie}')" class="custom-control-input keepcheck" id="customSwitch${entry.idPharmacie}" checked>
                                                               </c:if>
                                                               <c:if test="${pharmacieDao.getById(id).getEn_garde() == false}">
                                                                    <input type="checkbox"  name="checkgarde" onchange="toggleGarde('${entry.idPharmacie}')" class="custom-control-input keepcheck" id="customSwitch${entry.idPharmacie}">
                                                               </c:if>
                                                                <label class="custom-control-label" for="customSwitch${entry.idPharmacie}">Toggle this switch</label>
												          </div>
                                                          <input type="text" hidden name="idd" value="${entry.idPharmacie }">
												          <button id="submit-toggle${entry.idPharmacie}" type="submit" style="display:none;"></button>
                                                        </form>
                                                        </td>
                                                        <td>
                                                            <a class="btn btn-danger " href="<c:url value="/admin"><c:param name = "dlte_pharmacie" value = "${entry.idPharmacie}"/></c:url>">
                                                                <img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />
                                                                &nbsp;delete
                                                            </a>
                                                        </td>
                                                    </tr>
                                                
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${allPharmacies == null}">
                                                <tr>
                                                    <td colspan="5">AUCUN PHARMACIES</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- !List Pharmacies section -->

            <!-- List Hospitals section -->
            <div id="hospitals_Section" style="display:none;">
                <div class="recent-grid-comments">
                    <div class="projects">
                        <div class="card">
                            <div class="card-header">
                                <h3>List des hopitales</h3>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table width="100%">
                                        <thead>
                                            <tr>
                                                <td>Name</td>
                                                <td>telephone</td>
                                                <td>ville</td>
                                                <td>Delete</td>
                                                <td>show profile</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:if test="${!allHospitals.isEmpty()}">
                                                <c:forEach var="entry" items="${allHospitals}">
                                                    <tr>
                                                        <td> ${entry.name}</td>
                                                        <td>${entry.tel}</td>
                                                        <td>${entry.getVille()} </td>
                                                        <td>
                                                            <a class="btn btn-danger " href="<c:url value="/admin"><c:param name = "dlte_hopital" value = "${entry.idHopital}"/></c:url>">
                                                                <img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />
                                                                &nbsp;delete
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <a class="btn btn-success " href="<c:url value="/admin"><c:param name = "show_hopital" value = "${entry.idHopital}"/></c:url>">
                                                                <img src="https://img.icons8.com/metro/14/ffffff/approve.png"/>
                                                                &nbsp;show profile
                                                            </a>
                                                        </td>
                                                    </tr>
                                                
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${allHospitals == null}">
                                                <tr>
                                                    <td colspan="5">AUCUN Hopital</td>
                                                </tr>
                                            </c:if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- !List Hospitals section -->

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
                            <button onclick="show('Demmandes')">See all <span class="las la-arrow-right"></span></button>
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
	    <script src='http://code.jquery.com/jquery-1.10.2.min.js'></script>
	    <script>
			
         function toggleGarde(id){
        	document.getElementById('submit-toggle'+id).click();
        } 
        
    
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
        document.getElementById('main_place').innerHTML = document.getElementById('dashboard').innerHTML;
        
        function show(param_div_id) {
            document.getElementById('main_place').innerHTML = document.getElementById(param_div_id).innerHTML;
        }

        function handleOnLoad(){
            var btn = document.getElementById('dashboard');
            btn.click();
        }

          

    </script>
</body>
</html>