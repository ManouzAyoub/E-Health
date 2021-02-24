<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!--  This file has been downloaded from bootdey.com    @bootdey on twitter -->
    <!--  All snippets are MIT license http://bootdey.com/license -->
    <title>${user.firstname} ${user.lastname}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <style type="text/css">
    	

        body{
            margin-top:20px;
            background:#f5f5f5;
        }
        /**
        * Panels
        */
        /*** General styles ***/
        .panel {
          box-shadow: none;
        }
        .panel-heading {
          border-bottom: 0;
        }
        .panel-title {
          font-size: 17px;
        }
        .panel-title > small {
          font-size: .75em;
          color: #999999;
        }
        .panel-body *:first-child {
          margin-top: 0;
        }
        .panel-footer {
          border-top: 0;
        }

        .panel-default > .panel-heading {
            color: #333333;
            background-color: transparent;
            border-color: rgba(0, 0, 0, 0.07);
        }

        form label {
            color: #999999;
            font-weight: 400;
        }

        .form-horizontal .form-group {
          margin-left: -15px;
          margin-right: -15px;
        }
        @media (min-width: 768px) {
          .form-horizontal .control-label {
            text-align: right;
            margin-bottom: 0;
            padding-top: 7px;
          }
        }

        .profile__contact-info-icon {
            float: left;
            font-size: 18px;
            color: #999999;
        }
        .profile__contact-info-body {
            overflow: hidden;
            padding-left: 20px;
            color: #999999;
        }
        .profile-avatar {
          width: 200px;
          position: relative;
          margin: 0px auto;
          margin-top: 196px;
          border: 4px solid #f3f3f3;
        }
    </style>
</head>
<body>


<div class="container bootstrap snippets bootdeys">
<div class="row">
  <div class="col-xs-12 col-sm-9">
    <form method="POST" action="<c:url value="UserProfile"></c:url>"  class="form-horizontal">
      <div class="panel panel-default">
        <div class="panel-heading">
        <h4 class="panel-title">Votre informations</h4>
        </div>
        <div class="panel-body">
          <div class="form-group">
            <label class="col-sm-2 control-label">Nom</label>
            <div class="col-sm-10">
              <input type="text" name="nom" value="${user.lastname}" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">Prénom</label>
            <div class="col-sm-10">
              <input type="text" name="prenom" value="${user.firstname}" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
              <input type="text" name="email" value="${user.email}" class="form-control">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">Téléphone</label>
            <div class="col-sm-10">
              <input type="text" name="tel" value="${user.tel}" class="form-control">
            </div>
          </div>
        </div>
      </div>

      

      <div class="panel panel-default">
        <div class="panel-heading">
        <h4 class="panel-title">Security</h4>
        </div>
          <div class="panel-body">
            <div class="form-group">
              <label class="col-sm-2 control-label">Current password</label>
              <div class="col-sm-10">
                <input type="password" name="last_pass" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">New password</label>
              <div class="col-sm-10">
                <input type="password" name="new_pass" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Confirmation password</label>
              <div class="col-sm-10">
                <input type="password" name="confirmation" class="form-control">
              </div>
            </div>
            
            <div class="form-group">
              <div class="col-sm-10 col-sm-offset-2">
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-default">Cancel</button>
              </div>
            </div>
          </div>
      </div>
    </form>
  </div>
</div>
</div>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	

</script>
</body>
</html>