<%-- 
    Document   : participantForm
    Created on : 9 févr. 2022, 11:24:15
    Author     : Guiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Participant</title>
    </head>
    <body>
        <%@include file="../header.html" %>
        <div class="container-sm">
            <c:if test="${null == form.msgSucces || empty form.msgSucces}">
            <h1>Ajouter un participant!</h1>
            <form action="" method="post" class="row g-3 needs-validation">
                <input type="hidden" name="id" id="id" value="${p.id}">
                <div class="form-group">
                    <label for="code">Identifiant du participant</label>
                    <input type="text" name="code" class="form-control" id="code" aria-describedby="codeHelp" placeholder="identifiant..." value="${p.code}" required>
                    <span id="codeHelp" class="alert-danger" >${form.errors["code"]}</span>
                </div>
                <div class="form-group">
                    <label for="firstname">Prenom</label>
                    <input type="text" name="firstname" class="form-control" id="firstname" placeholder="Prenom..." value="${p.firstname}">
                    <span id="fitstnameHelp" class="alert-danger" role="alert">${form.errors["firstname"]}</span>
                </div>
                <div class="form-group">
                    <label for="lastname">Nom</label>
                    <input type="text" name="lastname" class="form-control" id="lastname" placeholder="Nom..." value="${p.lastname}" >
                    <span id="lastnameHelp" class="alert-danger" role="alert">${form.errors["lastname"]}</span>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" name="email" class="form-control" id="email" placeholder="Email..." value="${p.email}">
                    <span id="emailHelp" class="alert-danger" role="alert">${form.errors["email"]}</span>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="Password..." value="${p.password}">
                    <span id="passwordHelp" class="alert-danger" role="alert">${form.errors["password"]}</span>
                </div>
                <!--<div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>-->
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            </c:if>
            <c:if test="${!empty form.msgSucces}">
                <h2>${form.msgSucces}</h2>
            </c:if>

            <c:if test="${!empty errorConn}">
                <h2>${errorConn}</h2>
            </c:if>
        </div>
    </body>
</html>
