<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<c:url value="/DoctorDashboard/assets/css/dashboard.css"></c:url>">

    <!-- Google Maps API -->
    <script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDcybDNa2i9CePsLK9l7rAhcAafXMGALcY&libraries=places&callback=initMap"> </script>
</head>
<body>
    
    <input type="checkbox" id="nav-toggle">
    <div class="sidebar">
        <div class="sidebar-brand">
            <img src="./assets/img/EHealthLogo.png" style="width: 250px;" alt="">
        </div>
        <div class="sidebar-menu">
            <ul>
                <li>
                    <a href="#"  class="buttons active" onClick="handleClick(event)">
                        <span class="las la-igloo"></span>
                        <span class="sideebarText">Tableau de bord</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons" onClick="handleClick(event)">
                        <span class="las la-users"></span>
                        <span class="sideebarText">Docteur</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons" onClick="handleClick(event)">
                        <span class="las la-clipboard-list"></span>
                        <span class="sideebarText">Cabinet</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons" onClick="handleClick(event)">
                        <span class="las la-star"></span>
                        <span class="sideebarText">Evaluation</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons" onClick="handleClick(event)">
                        
                        <span class="las la-hospital"></span>
                        <span class="sideebarText">Associations</span>
                    </a>
                </li>

                <li style="height: 50px;">
                    
                </li>

                <li>
                    <a class="deconnexion" href="#">
                        
                        <span class="las la-door-open"></span>
                        <span class="sideebarText">Déconnexion</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="main-content" >
        <header>
            <div class="header-title">
                <h2>
                    <label onclick="toggleBtnClick()" for="nav-toggle">
                        <span class="las la-bars"></span>
                    </label>
                    <span id="page-name">Tableau de bord</span>
                </h2>
            </div>

            <div class="user-wrapper">
                <img src="data:image/png;base64,${image}" width="40px" height="40px" alt="">
                <div class="user-wrapper-info">
                    <h4>${docteur.firstname} ${docteur.lastname}</h4>
                    <small>Medecin</small>
                </div>
            </div>
        </header>

        <main>
            <div class="slidebar-menu"  id="dashboard">
                <div class="cards">
                    <div class="card-single">
                        <div>
                            <h1>${numberOfRating}</h1>
                            <span>Votes</span>
                        </div>
                        <div class="dashboard_icon">
                            <span class="las la-star"></span>
                        </div>
                    </div>
                    <div class="card-single">
                        <div>
                            <h1>${nbrsOfComments}</h1>
                            <span>Commentaires</span>
                        </div>
                        <div class="dashboard_icon">
                            <span class="las la-comment"></span>
                        </div>
                    </div>
                    <div class="card-single">
                        <div>
                            <h1>${nbrAssociation}</h1>
                            <span>Associations</span>
                        </div>
                        <div class="dashboard_icon">
                            <span class="las la-hospital"></span>
                        </div>
                    </div>
                </div>
    
                <div class="recent-grid">
                    <div class="comments">
                        <div class="demmande_card">
                            <div class="card-header">
                                <h3>Commentaires</h3>
                                <button onclick="voireComments()">Voire tous<span class="las la-arrow-right"></span></button>
                            </div>
                            <div class="demmande-card-body">
                                <div class="table-responsive">
                                    <table width="100%">
                                        <thead>
                                            <tr>
                                                <td>Username</td>
                                                <td>Vote</td>
                                                <td>Commentaire</td>
                                            </tr>
                                        </thead>
                                        <tbody>
    
                                            <!-- Selement 5 -->
                                            <c:if test="${!commentaires.isEmpty()}">
                                                <c:forEach var="commentaire" items="${commentaires}" begin="1" end="5">
                                                    <tr>
                                                        <td>${commentaire.getUser().getFirstname()} ${commentaire.getUser().getLastname()}</td>
                                                        <td style="width: 150px;">
                                                            <div class="text-warnning">
                                                                <span><i class="las la-lg la-star"></i></span>
                                                                <span><i class="las la-lg la-star"></i></span>
                                                                <span><i class="las la-lg la-star"></i></span>
                                                                <span><i class="lar la-lg la-star"></i></span>
                                                                <span><i class="lar la-lg la-star"></i></span>
                                                            </div>
                                                        </td>
                                                            
                                                        <td class="">
                                                            <span class="">${commentaire.getCommentaire()}</span>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>

                                            <c:if test="${commentaires == null}">
                                                <tr>
                                                    <td colspan="3">aucun commentaire</td>
                                                </tr>
                                            </c:if>
    
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
    
                    <div class="association">
                        <div class="demmande_card">
                            <div class="card-header">
                                <h3>Associations</h3>
                                <button onclick="voireAssociations()">Voire tous<span class="las la-arrow-right"></span></button>
                            </div>
                            <div class="demmande-card-body">
                                <div class="table-responsive">
                                    <table width="100%">
                                        <thead>
                                            <tr>
                                                <td>Hopiteaux</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- Selement 2 -->
                                            <c:if test="${!hopitaux.isEmpty()}">
                                                <c:forEach var="hopital" items="${hopitaux}" begin="1" end="2">
                                                    <tr>
                                                        <td>${hopital.name}</td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${ hopitaux == null }">
                                                    <tr>
                                                        <td>aucun hopital</td>
                                                    </tr>
                                            </c:if>
                                        </tbody>
    
                                        <thead>
                                            <tr>
                                                <td>Cliniques</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- Selement 2 -->
                                            <c:if test="${!cliniques.isEmpty()}">
                                                <c:forEach var="clinique" items="${cliniques}" begin="1" end="2">
                                                    <tr>
                                                        <td>${clinique.name}</td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${ cliniques == null }">
                                                    <tr>
                                                        <td>aucun hopital</td>
                                                    </tr>
                                            </c:if>
                                        </tbody>
    
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="slidebar-menu" id="Doctor" style="display: none;">

                

                    <!-- Information Personnel section -->
                    <div class="recent-grid">
                        <div class="InfoPerso">
                            <div class="demmande_card">
                                <div class="card-header">
                                    <h3>Informations personneles</h3>
                                </div>
                            <!-- Start Form Personnel -->
                            <form method="POST" action="<c:url value="InformationPerso"></c:url>">
                                <div class="demmande_card">
                                    <div class="table-responsive">
                                        <table>
                                            <tr>
                                                <input type="hidden" value="${docteur.cin}" name="id">
                                                <td><label for="">Nom :</label></td>
                                                <td><input name="Nom" value="${docteur.lastname}" type="text" class="infoInput" disabled><br></td>
                                            </tr>
    
                                            <tr>
                                                <td><label for="">Prenom  :</label></td>
                                                <td><input name="Prenom" value="${docteur.firstname}" type="text" class="infoInput" disabled><br></td>
                                            </tr>

                                            <!-- <tr>
                                                <td><label for="">Date de naissance :</label></td>
                                                <td><input name="Date_naissance" value="" type="date" value="2018-07-22" class="infoInput" disabled><br></td>
                                            </tr> -->

                                            <tr>
                                                <td><label for="">Sexe :</label></td>
                                                <td>
                                                    <select name="sexe" class="select-css infoInput" disabled>
                                                        <option value="Homme">Homme</option>
                                                        <option value="Femme">Femme</option>
                                                    </select>
                                                </td>
                                            </tr>
    
                                            <tr>
                                                <td><label for="">Adresse :</label></td>
                                                <td><input name="Adresse" value="${docteur.adresse}" type="text" class="infoInput" disabled><br></td>
                                            </tr>
    
                                            <tr>
                                                <td><label for="">Telephone :</label></td>
                                                <td><input name="Telephone" value="${docteur.tel}" type="text" class="infoInput" disabled><br></td>
                                            </tr>
    
                                            <tr>
                                                <td><label for="">Ville :</label></td>
                                                <td><input name="Ville" value="${docteur.ville}" type="text" class="infoInput" disabled><br></td>
                                            </tr>
    
                                            <tr>
                                                <td rowspan="2"><label for="">Langues :</label></td>
                                                <td>
                                                    <label style="margin-right: 5px;" for="English"><input style="margin-right: 2px;" name="langue" value="English" id="English" type="checkbox" class="infoInput" disabled>English</label>
                                                    <label style="margin-right: 5px;" for="Spanish"><input style="margin-right: 2px;" name="langue" value="Spanish" id="Spanish" type="checkbox" class="infoInput" disabled>Spanish</label>
                                                    <label style="margin-right: 5px;" for="Chinese"><input style="margin-right: 2px;" name="langue" value="Chinese" id="Chinese" type="checkbox" class="infoInput" disabled>Chinese</label>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>
                                                    <label style="margin-right: 5px;" for="Frensh"><input style="margin-right: 2px;" name="langue" value="Frensh" id="Frensh" type="checkbox" class="infoInput" disabled>Frensh</label>
                                                    <label style="margin-right: 5px;" for="Arabic"><input style="margin-right: 2px;" name="langue" value="Arabic" id="Arabic" type="checkbox" class="infoInput" disabled>Arabic</label>
                                                </td>
                                            </tr>
    
                                            <tr>
                                                <td><label for="">Spécialité :</label></td>
                                                <td>
                                                    <select name="speciality"  class="select-css infoInput" disabled>
                                                        <option>Chirurgie esthétique</option>
                                                        <option>Chirurgie pédiatrique</option>
                                                        <option>Chirurgie vasculaire</option>
                                                        <option>Chirurgie viscérale et digestive</option>
                                                        <option>Gynécologie obstétrique</option>
                                                        <option>Neurochirurgie </option>
                                                        <option>Allergologie</option>
                                                        <option>Anatomie et cytologie pathologique</option>
                                                        <option>Anesthésie</option>
                                                        <option>Cardiologie</option>
                                                        <option>Dermatologie</option>
                                                        <option>Endocrinologie-nutrition</option>
                                                        <option>Génétique</option>
                                                        <option>Allergologie</option>
                                                        <option>Gynécologie médicale</option>
                                                        <option>Hématologie</option>
                                                        <option>Médecine générale</option>
                                                        <option>Médecine physique et réadaptation</option>
                                                        <option>Néphrologie</option>
                                                        <option>Neurologie</option>
                                                        <option>Psychiatrie</option>
                                                        <option>Radiologie</option>
                                                        <option>Réanimation</option>
                                                        <option>Santé publique</option>
                                                        <option>Urgentiste</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            
                                            <tr>
                                                <td><label for="">Description :</label></td>
                                                <td><textarea name="description" id="description" cols="60" rows="5" class="infoInput" disabled>${docteur.description}</textarea></td>
                                            </tr>
    
                                            <tr>
                                                <td><label for="">Biologie:</label></td>
                                                <td><textarea name="biographie" id="biologie" cols="60" rows="5" class="infoInput" disabled>${docteur.biographie}</textarea></td>
                                            </tr>
                                        </table>
                                    </div>
    
                                    <div class="image-card">
                                        <label id="modifierInfoPerso" onclick="modifierInfoPerso()">Modifier</label>
                                        <input type="submit" id="enregistrerInfoPerso" value="Enregistrer" style="display: none;">
                                        <label id="annulerInfoPerso" onclick="reloadPage()" style="display: none;">Annuler</label>
                                    </div>
                                </div>
                            </form>
                            <!-- !End Form Personnel -->
                        </div>
                    </div>
                        
                        <form method="POST" action="<c:url value="ChangeImageDoctor"></c:url>" enctype="multipart/form-data">
                            <div class="imagePerso">
                                <div class="image-card">
                                    <img id="imageDoctor" src="data:image/png;base64,${image}" width="150px" alt=""><br>
                                    <input type="text" name="d" value="${docteur.cin}">
                                    <input id="imageInput" accept="image/*" type="file" name="image" style="display: none;" onchange="loadImage(event)">
                                    <div class="image-card">
                                        <label id="modifierImagePerso" onclick="modifierImagePerso()">Changer l'image</label>
                                        <input type="submit" id="enregistrerImagePerso" value="Enregistrer" style="display: none;">
                                        <label id="annulerImagePerso" onclick="reloadPage()" style="display: none;">Annuler</label>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- !Information Personnel section -->

                    <!-- Education  section -->
                    <div class="recent-grid">

                        <div class="education">
                            <div class="demmande_card">
                                <div class="card-header">
                                    <h3>Education</h3>
                                    <label onclick="ajouterEduc()">Ajouter</label>
                                </div>
                                <div class="demmande-card-body">
                                    <div class="table-responsive">
                                        <table style="width: 100%;">
                                            <thead>
                                                <tr>
                                                    <td>Année</td>
                                                    <td>Diplome</td>
                                                    <td>Etablissement</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${!educations.isEmpty()}">
                                                    <c:forEach var="education" items="${educations}">
                                                        <tr>
                                                            <td>${education.anneeEduc}</td>
                                                            <td>${education.education}</td>
                                                            <td>${education.descEduc}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${educations == null}">
                                                    <tr>
                                                        <td colspan="3"> aucun education</td>
                                                    </tr>
                                                </c:if>
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="nouvelleEducation" style="display: none;">
                            <!-- Start Education Formulaire -->
                            <form method="POST" action="<c:url value="EducationForm"></c:url>">
                                <div class="demmande_card">
                                    <div class="card-header">
                                        <h3>Nouvelle education</h3>
                                    </div>
                                    <div class="demmande-card-body">
                                        <div class="table-responsive">
                                            <table style="width: 100%;">
                                                <tr>
                                                    <td>Année</td>
                                                    <td>
                                                        <select name="anneeDiplome" id="anneeDiplome"></select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Diplome</td>
                                                    <td><input name="nomDiplome" type="text" class="infoInput"><br></td>
                                                </tr>
                                                <tr>
                                                    <td>Etablissement</td>
                                                    <td><input name="etablissementDiplome" type="text" class="infoInput"><br></td>
                                                </tr>
                                                <input name="doc" value="${docteur.cin}" type="hidden" class="infoInput">
                                            </table>
                                        </div>
                                        <div class="image-card">
                                            <input type="submit" id="enregistrerEducation" value="Enregistrer">
                                            <label id="annulerEducation" onclick="hideNewEduc()">Annuler</label>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <!-- Send Education Formulaire -->
                        </div>

                    </div>
                    <!-- !Education  section -->

                    <!-- Recompense  section -->
                    <div class="recent-grid">

                        <div class="Recompenses">
                            <div class="demmande_card">
                                <div class="card-header">
                                    <h3>Récompenses</h3>
                                    <label onclick="ajouterAward()">Ajouter</label>
                                </div>
                                <div class="demmande-card-body">
                                    <div class="table-responsive">
                                        <table style="width: 100%;">
                                            <thead>
                                                <tr>
                                                    <td>Année</td>
                                                    <td>Récompense</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${!recompences.isEmpty()}">
                                                    <c:forEach var="recompence" items="${recompences}">
                                                        <tr>
                                                            <td>${recompence.annee}</td>
                                                            <td>${recompence.name}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${recompences == null}">
                                                    <tr>
                                                        <td colspan="2"> aucun recompence</td>
                                                    </tr>
                                                </c:if>
        
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="nouvelleRecompenses" style="display: none;">
                            <!-- Start Recompense Formulaire -->
                            <form method="POST" action="<c:url value="RecompenseForm"></c:url>">
                                <div class="demmande_card">
                                    <div class="card-header">
                                        <h3>Nouvelle Récompenses</h3>
                                    </div>
                                    <div class="demmande-card-body">
                                        <div class="table-responsive">
                                            <table style="width: 100%;">
                                                <tr>
                                                    <td>Année</td>
                                                    <td>
                                                        <select name="anneeRecompense" id="anneeRecompense"></select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Récompense</td>
                                                    <td><input name="NomRecompense" type="text" class="infoInput"><br></td>
                                                </tr>
                                            </table>
                                            <input name="doc" value="${docteur.cin}" type="hidden" class="infoInput">
                                        </div>
                                        <div class="image-card">
                                            <input type="submit" id="enregistrerRecompenses" value="Enregistrer">
                                            <label id="annulerRecompenses" onclick="hideNewAward()">Annuler</label>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <!-- End Recompense Formulaire -->
                        </div>

                    </div>
                    <!-- !Recompense  section -->

                
                
            </div>

            <div class="slidebar-menu" id="Cabinet" style="display: none;">
                
                    <!-- Information du cabinet section -->
                    <form method="POST" action="<c:url value="InfoCabinet"></c:url>">
                        <div class="recent-grid">
                            <div class="InfoCabinet">
                                <div class="demmande_card">
                                    <div class="card-header">
                                        <h3>Informations du cabinet</h3>
                                    </div>
                                    <div class="demmande_card">
                                        <div class="table-responsive">
                                            <table>
                                                <!-- <tr>
                                                    <td><label for="adresseCabinet">Adresse :</label></td>
                                                    <td><input name="adresseCabinet" type="text" class="infoInputCabinet" disabled><br></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td><label for="telephoneCabinet">Telephone :</label></td>
                                                    <td><input name="telephoneCabinet" type="text" class="infoInputCabinet" disabled><br></td>
                                                </tr> -->
                                                <input type="hidden" value="${docteur.cin}" name="id">
                                                <tr>
                                                    <td rowspan="2"><label>Horaires de travail :</label></td>
                                                    <td>
                                                        Le : &nbsp;
                                                        <select name="jour_debut" class="infoInputCabinet" id="jour_debut" disabled></select>
                                                        &nbsp; Jusqu'à : &nbsp;
                                                        <select name="jour_fin" class="infoInputCabinet" id="jour_fin" disabled></select>
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <td>
                                                        De : &nbsp;
                                                        <select name="heure_debut" class="infoInputCabinet" id="heure_debut" disabled></select>
                                                        &nbsp; Jusqu'à : &nbsp;
                                                        <select name="heure_fin" class="infoInputCabinet" id="heure_fin" disabled></select>
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <td rowspan="3"><label for="services">Services :</label></td>
                                                    <td>
                                                        <label for="telemedecine"><input name="telemedecine" type="checkbox" class="infoInputCabinet" value="Télémédecine" disabled> &nbsp; Télémédecine</label>
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <td>
                                                        <label for="Consultation_domicile"><input name="Consultation_domicile" type="checkbox" class="infoInputCabinet" value="Consultation a domicile" disabled> &nbsp; Consultation a domicile</label>
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <td>
                                                        <label for="renderVousTelephone"><input name="renderVousTelephone" type="checkbox" class="infoInputCabinet" value="Prend rendez-vous par téléphone" disabled> &nbsp; Prend rendez-vous par téléphone</label>
                                                        
                                                    </td>
                                                </tr>
    
                                            </table>
                                        </div>
    
                                        <div class="image-card">
                                            <label id="modifierInfoCabinet" onclick="modifierInfoCabinet()">Modifier</label>
                                            <input type="submit" id="enregistrerInfoCabinet" value="Enregistrer" style="display: none;">
                                            <label id="annulerInfoCabinet" onclick="reloadPage()" style="display: none;">Annuler</label>
                                        </div>
    
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- !Information du cabinet section -->

                    <!-- Localisation du cabinet section -->
                    <form method="POST" action="<c:url value="ChangeLocalisation"></c:url>">
                        <div class="recent-grid">
                            <div class="InfoCabinet">
                                <div class="demmande_card">
                                    <div class="card-header">
                                        <h3>Localosation</h3>
                                    </div>
                                    <div class="demmande_card">
                                        <div class="table-responsive">
                                            <table style="width: 100%;">
                                                <tr>
                                                    <td><label for="place_id">Id de location :</label></td>
                                                    <td><input name="place_id" id="place_id" style="width: 100%;" value="ChIJSZHKs5O3sw0R-zl1pDjBn_4" type="text" disabled></td>
                                                </tr>
                                            </table>
                                           
                                        </div>
                                        <div class="image-card">
                                            <label class="seeplace" onclick="initMap()">Afficher en map</label>
                                            <label id="modifierplace_id" onclick="modifierplace_id()">Modifier</label>
                                            <label id="Trouverplace_id" onclick="Trouverplace_id()" style="display: none;">Trouver id</label>
                                            <input type="submit" id="enregistrerplace_id" value="Enregistrer" style="display: none;">
                                            <label id="annulerplace_id" onclick="reloadPage()" style="display: none;">Annuler</label>
                                        </div>
                                        
                                        <div id="map"></div>
    
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- !Localisation du cabinet section -->
                
            </div>

            <div class="slidebar-menu" id="Evaluation" style="display: none;">
                <!-- Start Votes -->
                <div class="Votes">
                    <div class="demmande_card">
                        <div class="card-header">
                            <h3>Votes</h3>
                        </div>
                        <div class="demmande_card">

                            <div class="table-responsive">
                                <table style="width: 100%;">
                                    <tr>
                                        <td rowspan="2"><h1>${average}</h1></td>
                                        <td>
                                            <c:set var="nbr" value="${averageOfRating}"></c:set>
                                            <c:set var="result" value="${ 5 - nbr }"></c:set>
                                            <div class="text-warnning">
                                                <c:forEach var="a" begin="1" end="${nbr}">
                                                    <span><i class="las la-lg la-star"></i></span>
                                                </c:forEach>
                                                <c:forEach var="b" begin="1" end="${result}">
                                                    <span><i class="lar la-lg la-star"></i></span>
                                                </c:forEach>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span style="vertical-align : middle;" class="smallComment"> Basée sur ${numberOfRating} votes</span></td>
                                    </tr>
                                </table>
                            </div>

                            <div class="table-responsive">
                                <table style="width: 100%;">
                                    <tr>
                                        <td style="width: 25%;">5 étoiles</td>
                                        <td style="width: 65%;">
                                            <div class="meter orange nostripes">
                                                <span style="width: ${progressBar.getOrDefault(Integer.valueOf(5),"0") }%"></span>
                                            </div>
                                        </td>
                                        <td style="width: 10%;">(${ evaluations.getOrDefault(Integer.valueOf(5),Long.valueOf(0)) })</td>
                                    </tr>

                                    <tr>
                                        <td style="width: 25%;">4 étoiles</td>
                                        <td style="width: 65%;">
                                            <div class="meter orange nostripes">
                                                <span style="width: ${progressBar.getOrDefault(Integer.valueOf(4),"0") }%"></span>
                                            </div>
                                        </td>
                                        <td style="width: 10%;">(${ evaluations.getOrDefault(Integer.valueOf(4),Long.valueOf(0)) })</td>
                                    </tr>

                                    <tr>
                                        <td style="width: 25%;">3 étoiles</td>
                                        <td style="width: 65%;">
                                            <div class="meter orange nostripes">
                                                <span style="width: ${progressBar.getOrDefault(Integer.valueOf(3),"0") }%"></span>
                                            </div>
                                        </td>
                                        <td style="width: 10%;">(${ evaluations.getOrDefault(Integer.valueOf(3),Long.valueOf(0)) })</td>
                                    </tr>

                                    <tr>
                                        <td style="width: 25%;">2 étoiles</td>
                                        <td style="width: 65%;">
                                            <div class="meter orange nostripes">
                                                <span style="width: ${progressBar.getOrDefault(Integer.valueOf(2),"0") }%"></span>
                                            </div>
                                        </td>
                                        <td style="width: 10%;">(${ evaluations.getOrDefault(Integer.valueOf(2),Long.valueOf(0)) })</td>
                                    </tr>

                                    <tr>
                                        <td style="width: 25%;">1 étoile</td>
                                        <td style="width: 65%;">
                                            <div class="meter orange nostripes">
                                                <span style="width: ${progressBar.getOrDefault(Integer.valueOf(1),"0") }%"></span>
                                            </div>
                                        </td>
                                        <td style="width: 10%;">(${ evaluations.getOrDefault(Integer.valueOf(1),Long.valueOf(0)) })</td>
                                    </tr>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>
                <!-- End Votes -->

                <div class="Commentaires">
                    <div class="demmande_card">
                        <div class="card-header">
                            <h3>Commentaires</h3>
                        </div>
                        <div class="demmande_card">

                            <div class="table-responsive">
                                <table width="100%">
                                    <thead>
                                        <tr>
                                            <td>Username</td>
                                            <td>Vote</td>
                                            <td>Commentaire</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <c:if test="${!commentaires.isEmpty()}">
                                            <c:forEach var="commentaire" items="${commentaires}">
                                                <tr>
                                                    <td>${commentaire.getUser().getFirstname()} ${commentaire.getUser().getLastname()}</td>
                                                    <td style="width: 150px;">
                                                        <div class="text-warnning">
                                                            <span><i class="las la-lg la-star"></i></span>
                                                            <span><i class="las la-lg la-star"></i></span>
                                                            <span><i class="las la-lg la-star"></i></span>
                                                            <span><i class="lar la-lg la-star"></i></span>
                                                            <span><i class="lar la-lg la-star"></i></span>
                                                        </div>
                                                    </td>
                                                        
                                                    <td class="">
                                                        <span class="">${commentaire.getCommentaire()}</span>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${commentaires == null}">
                                            <tr>
                                                <td colspan="3">aucun commentaire</td>
                                            </tr>
                                        </c:if>

                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>
                
            </div>

            <div class="slidebar-menu" id="Associations" style="display: none;">

                <div class="Hopiteaux">
                    <div class="demmande_card">
                        <div class="card-header">
                            <h3>Hopiteaux</h3>
                        </div>
                        <div class="demmande-card">
                            <div class="table-responsive">
                                <table width="100%">
                                    
                                    <tbody>
                                        <c:if test="${!hopitaux.isEmpty()}">
                                            <c:forEach var="hopital" items="${hopitaux}">
                                                <tr>
                                                    <td>${hopital.name}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${ hopitaux == null }">
                                                <tr>
                                                    <td>aucun hopital</td>
                                                </tr>
                                        </c:if>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="Cliniques">
                    <div class="demmande_card">
                        <div class="card-header">
                            <h3>Cliniques</h3>
                        </div>
                        <div class="demmande-card">
                            <div class="table-responsive">
                                <table width="100%">
                                    <tbody>
                                        <c:if test="${!cliniques.isEmpty()}">
                                            <c:forEach var="clinique" items="${cliniques}">
                                                <tr>
                                                    <td>${clinique.name}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${ cliniques == null }">
                                                <tr>
                                                    <td>aucun clinique</td>
                                                </tr>
                                        </c:if>
                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </main>
    </div>

    
    
    <script type="text/javascript" src="<c:url value="/DoctorDashboard/assets/js/dashboard.js"/>"></script>
</body>
</html>