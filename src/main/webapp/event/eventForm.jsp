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
        <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.0.0/css/all.css"><title>Event</title>
    </head>
    <body>
        <%@include file="../header.html" %>
<!--        <div class="container-sm">-->
        <div class="login-form-bg h-100 mt-5">
            <div class="container h-100">
                <div class="row justify-content-center h-100">
                    <div class="col-xl-6">
                        <div class="form-input-content">
                            <div class="card login-form mb-0">
                                <div class="card-body pt-5">
                                    <c:if test="${null == form.msgSucces || empty form.msgSucces}">
                                        <h2><c:if test="${e != null }">Modifier</c:if><c:if test="${e == null }">Ajouter</c:if> un evenement!</h2>
                                    <form action="" method="post" class="row g-3 needs-validation">
                                        <input type="hidden"  name="id" value="${ e.id }"/>
                                        <div class="form-group">
                                            <label for="eventName">Nom de l'evenement</label>
                                            <input type="text" name="eventName" class="form-control" id="eventName" aria-describedby="nameHelp" placeholder="Nom evenement" value="${e.eventName}" required>
                                            <span id="nameHelp" class="alert-danger" >${form.errors["eventName"]}</span>
                                        </div>
                                        <div class="form-group">
                                            <label for="startDate">Date debut</label>
                                            <input type="date" name="startDate" class="form-control" id="startDate" placeholder="jj-mm-aaaa" value="${e.startDate}">
                                            <span id="nameStartDateHelp" class="alert-danger" role="alert">${form.errors["startDate"]}</span>
                                        </div>
                                        <div class="form-group">
                                            <label for="endDate">Date fin</label>
                                            <input type="date" name="endDate" class="form-control" id="endDate" placeholder="jj-mm-aaaa" value="${e.endDate}">
                                            <span id="EndDateHelp" class="alert-danger" role="alert">${form.errors["endDate"]}</span>
                                        </div>
                                        <div class="form-group">
                                            <label for="startTime">Heure debut</label>
                                            <input type="time" name="startTime" class="form-control" id="startTime" placeholder="HH:mm" value="${e.startTime}">
                                            <span id="startTimeHelp" class="alert-danger" role="alert">${form.errors["startTime"]}</span>
                                        </div>
                                        <div class="form-group">
                                            <label for="endTime">Heure fin</label>
                                            <input type="time" name="endTime" class="form-control" id="endTime" placeholder="HH:mm" value="${e.endTime}">
                                            <span id="endTimeHelp" class="alert-danger" role="alert">${form.errors["endTime"]}</span>
                                        </div>
                                        <div class="form-group">
                                            <label for="location">Lieu</label>
                                            <input type="text" name="location" class="form-control" id="location" placeholder="Lieu de l'evenement" value="${e.location}">
                                        </div>
                                        <div class="form-group">
                                            <label for="category">Categorie</label>
                                            <input type="text" name="category" class="form-control" id="category" placeholder="Categorie" value="${e.category}">
                                        </div>
                                        <div class="form-group">
                                            <label for="priority">Priorite</label>
                                            <input type="number" name="priority" class="form-control" id="priority" placeholder="La priorite" value="${e.priority}">
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

                                <c:if test="${!empty errorConn}">
                                    <h2>${errorConn}</h2>
                                </c:if>
                                <c:if test="${error.connectionError}">
                                    <h2>Pas de message d'erreurs</h2>
                                </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                                
        <%@include file="../footer.jsp" %>
    </body>
</html>
