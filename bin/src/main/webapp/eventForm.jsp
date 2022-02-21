<%-- 
    Document   : eventForm
    Created on : 28 déc. 2021, 01:28:38
    Author     : Guiro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-sm">
            <c:if test="${null == form.msgSucces || empty form.msgSucces}">
            <h1>Ajouter un evenement!</h1>
            <form action="" method="post" class="row g-3 needs-validation">
                <div class="form-group">
                    <label for="eventName">Nom de l'evenement</label>
                    <input type="text" value='' name="name" class="form-control" id="eventName" aria-describedby="nameHelp" placeholder="Nom evenement">
                    <span id="nameHelp" class="alert-danger" >${form.errors["name"]}</span>
                </div>
                <div class="form-group">
                    <label for="startDate">Date debut</label>
                    <input type="date" name="startDate" class="form-control" id="startDate" placeholder="jj-mm-aaaa">
                    <span id="nameStartDateHelp" class="alert-danger" role="alert">${form.errors["startDate"]}</span>
                </div>
                <div class="form-group">
                    <label for="endDate">Date fin</label>
                    <input type="date" name="endDate" class="form-control" id="endDate" placeholder="jj-mm-aaaa">
                    <span id="EndDateHelp" class="alert-danger" role="alert">${form.errors["endDate"]}</span>
                </div>
                <div class="form-group">
                    <label for="startTime">Heure debut</label>
                    <input type="time" name="startTime" class="form-control" id="startTime" placeholder="HH:mm">
                    <span id="startTimeHelp" class="alert-danger" role="alert">${form.errors["startTime"]}</span>
                </div>
                <div class="form-group">
                    <label for="endTime">Heure fin</label>
                    <input type="time" name="endTime" class="form-control" id="endTime" placeholder="HH:mm">
                    <span id="endTimeHelp" class="alert-danger" role="alert">${form.errors["endTime"]}</span>
                </div>
                <div class="form-group">
                    <label for="location">Lieu</label>
                    <input type="text" name="location" class="form-control" id="location" placeholder="Lieu de l'evenement">
                </div>
                <div class="form-group">
                    <label for="category">Categorie</label>
                    <input type="text" name="category" class="form-control" id="category" placeholder="Categorie">
                </div>
                <div class="form-group">
                    <label for="priority">Priorite</label>
                    <input type="number" name="priority" value="${form.event.priority}" class="form-control" id="priority" placeholder="La priorite">
                </div>
                <div class="form-group">
                    <label for="participants">Participants</label>
                    <input type="text" name="participants" class="form-control" id="participants" placeholder="Les participants">
                </div>
<!--                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>-->
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </c:if>
        <c:if test="${!empty form.msgSucces}">
            <h2>${form.msgSucces}</h2>
        </c:if>
            ${errorConn}
        </div>
    </body>
</html>
