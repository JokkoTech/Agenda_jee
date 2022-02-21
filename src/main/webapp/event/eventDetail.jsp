<%-- 
    Document   : eventDetail
    Created on : 11 févr. 2022, 11:24:46
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
        <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.0.0/css/all.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../header.html" %>
        <div class="container-sm">
            <h2>Les details de l'evenement ${ e.eventName }</h2>
            <div class="row">
                    <ul class="list-group col-sm-6">
                        <li class="list-group-item list-group-item-success">Nom de l'evenement : ${ e.eventName }</li>
                        <li class="list-group-item list-group-item-info">Date de l'evenement : ${ e.startDate }</li>
                        <li class="list-group-item list-group-item-success">Heure de l'evenement : ${ e.startTime }</li>
                        <li class="list-group-item list-group-item-info">Date de la Fin de l'evenement : ${ e.endDate }</li>
                        <li class="list-group-item list-group-item-success">Heure de la fin de l'evenement : ${ e.endTime }</li>
                        <li class="list-group-item list-group-item-info">Lieu de l'evenement : ${ e.location }</li>
                        <li class="list-group-item list-group-item-success">Category de l'evenement : ${ e.category }</li>
                        <li class="list-group-item list-group-item-info">Priority de l'evenement : ${ e.priority }</li>
                        <li class="list-group-item list-group-item-success">Nombre de participants : ${ e.participants.size() }</li>
                    </ul>
                    <div class="list-group col-sm-6">
                        <h3>Liste des participants</h3>
                        <%! String tmp = "success" ;%>
                        <c:forEach var="p" items="${ e.participants }">
                            <% if (tmp == "success") {
                                tmp = "info" ;
                            %>
                            <a href="#" class="list-group-item list-group-item-success">${p.firstname} ${p.lastname} ${p.email}</a>    
                            <%
                            }else{
                                tmp = "success" ;
                            %>
                            <a href="#" class="list-group-item list-group-item-info">${p.firstname} ${p.lastname} ${p.email}</a>
                            <%
                            }
                            
                            %>
                        </c:forEach>
                        <br/><button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Add participant</button>
                    </div>
            </div>
                    
            <!-- The Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                          <h4 class="modal-title">Add participant</h4>
                          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                      <form action="" method="post" class="row g-3 needs-validation">
                          <input type="hidden" name="id_event" id="id" value="${e.id}">
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
                          <button type="submit" class="btn btn-primary">Submit</button>
                      </form>
                    </div>

                  <!-- Modal footer -->
                  <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                  </div>

                </div>
              </div>
            </div>
        </div>
        <%@include file="../footer.jsp" %>
    </body>
</html>
