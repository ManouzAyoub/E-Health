<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="<c:url value="./assets/css/dashboard.css" />" >
</head>
<body>
    <input type="checkbox" id="nav-toggle">
    <div class="sidebar">
        <div class="sidebar-brand">
            <h2><span class="lab la-accusoft"></span> <span>Youssef</span></h2>
        </div>
        <div class="sidebar-menu">
            <ul>
                <li>
                    <a href="#" class="buttons active" onclick="handleClick(event);show('dashboard')">
                        
                        <span class="las la-igloo"></span>
                        Dashboard
                    </a>
                </li>
                <li>
                    <a href="#" class="buttons dash" onClick="handleClick(event);show('Demmandes')">
                        
                        <span class="las la-clipboard-list"></span>
                        Demmandes
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
                    <h4>Youssef El Gourari</h4>
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
                            <h4>Youssef El Gourari</h4>
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
                                  <%-- <c:forEach var="clinic" items="${clinics}">
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
                                 </c:forEach> --%>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
           <!-- demandes -->

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
                                            <tr>
                                                <td>MarouaXP</td>
                                                <td>Doctor</td>
                                                <td>Amine alaoui</td>
                                                <td>
                                                    <span class="status purple"></span>
                                                    bon service
                                                </td>
                                                <td><button class="delete"><img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />&nbsp;delete</button></td>
                                                <td><button class="approve"><img src="https://img.icons8.com/metro/14/ffffff/approve.png"/>&nbsp;approve</button></td>
                                            </tr>
                                            <tr>
                                                <td>YOUSSEF EL GOURARI</td>
                                                <td>Doctor</td>
                                                <td>Moustafa kadimi</td>
                                                <td>
                                                    <span class="status pink"></span>
                                                    il explique bien les conditions
                                                </td>
                                                <td><button class="delete"><img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />&nbsp;delete</button></td>
                                                <td><button class="approve"><img src="https://img.icons8.com/metro/14/ffffff/approve.png"/>&nbsp;approve</button></td>
                                            </tr>
                                            <tr>
                                                <td>YOUSSEF EL GOURARI</td>
                                                <td>doctor</td>
                                                <td>Moustafa kadimi</td>
                                                <td>
                                                    <span class="status orange"></span>
                                                    pourtant prix de visite trés cher.
                                                </td>
                                                <td><button class="delete"><img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />&nbsp;delete</button></td>
                                                <td><button class="approve"><img src="https://img.icons8.com/metro/14/ffffff/approve.png"/>&nbsp;approve</button></td>
                                            </tr>
                                            <tr>
                                                <td>ayoubx</td>
                                                <td>clinique</td>
                                                <td>Massira</td>
                                                <td>
                                                    <span class="status purple"></span>
                                                    il faut essayer de sourire plus
                                                </td>
                                                <td><button class="delete"><img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />&nbsp;delete</button></td>
                                                <td><button class="approve"><img src="https://img.icons8.com/metro/14/ffffff/approve.png"/>&nbsp;approve</button></td>
                                            </tr>
                                            <tr>
                                                <td>samira</td>
                                                <td>clinique</td>
                                                <td>tilila</td>
                                                <td>
                                                    <span class="status pink"></span>
                                                    les infirmières sont très sympathiques.
                                                </td>
                                                <td><button class="delete"><img src="https://img.icons8.com/metro/14/ffffff/delete-sign.png" />&nbsp;delete</button></td>
                                                <td><button class="approve"><img src="https://img.icons8.com/metro/14/ffffff/approve.png"/>&nbsp;approve</button></td>
                                            </tr>
                                            <tr>
                                                
            
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
                        <h1>54</h1>
                        <span>Users</span>
                    </div>
                    <div>
                        <span class="las la-users">
    
                        </span>
                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <h1>70</h1>
                        <span>Doctors</span>
                    </div>
                    <div>
                        <img src="https://img.icons8.com/ios/50/069c54/doctor-male.png"/>                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <h1>120</h1>
                        <span>Clinics</span>
                    </div>
                    <div>
                        <img src="https://img.icons8.com/carbon-copy/60/069c54/clinic.png"/>
                    </div>
                </div>
                <div class="card-single">
                    <div>
                        <h1>120</h1>
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
                                        <tr>
                                            <td>MarouaXP</td>
                                            <td>Doctor</td>
                                            <td>Amine alaoui</td>
                                            <td>
                                                <span class="status purple"></span>
                                                bon service
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>YOUSSEF EL GOURARI</td>
                                            <td>Doctor</td>
                                            <td>Moustafa kadimi</td>
                                            <td>
                                                <span class="status pink"></span>
                                                il explique bien les conditions
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>YOUSSEF EL GOURARI</td>
                                            <td>doctor</td>
                                            <td>Moustafa kadimi</td>
                                            <td>
                                                <span class="status orange"></span>
                                                pourtant prix de visite trés cher.
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>ayoubx</td>
                                            <td>clinique</td>
                                            <td>Massira</td>
                                            <td>
                                                <span class="status purple"></span>
                                                il faut essayer de sourire plus
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>samira</td>
                                            <td>clinique</td>
                                            <td>tilila</td>
                                            <td>
                                                <span class="status pink"></span>
                                                les infirmières sont très sympathiques.
                                            </td>
                                        </tr>
                                        <tr>
                                            
        
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
                            <div class="customer">
                                <div class="info">
                                    <img src="./assets/img/doc.jpg" width="40px" height="40px" alt="">
                                    <div>
                                        <h4>Mohamed moustafa</h4>
                                        <small>cabinet médical</small>
                                    </div>
                                </div>
                            </div>
                            <div class="customer">
                                <div class="info">
                                    <img src="./assets/img/doc2.png" width="40px" height="40px" alt="">
                                    <div>
                                        <h4>Alaoui youssef</h4>
                                        <small>cabinet médical</small>
                                    </div>
                                </div>
                            </div>
                            <div class="customer">
                                <div class="info">
                                    <img src="./assets/img/unknown.png" width="40px" height="40px" alt="">
                                    <div>
                                        <h4>Nour</h4>
                                        <small>pharmacie</small>
                                    </div>
                                </div>
                                
                            </div>
                            <div class="customer">
                                <div class="info">
                                    <img src="./assets/img/unknown.png" width="40px" height="40px" alt="">
                                    <div>
                                        <h4>tilila</h4>
                                        <small>clinique</small>
                                    </div>
                                </div>
                            </div>
                            <div class="customer">
                                <div class="info">
                                    <img src="./assets/img/unknown.png" width="40px" height="40px" alt="">
                                    <div>
                                        <h4>amal</h4>
                                        <small>pharmacie</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
            </div>
        </div>
            <!-- Dashboard -->

        </main>
    </div>

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