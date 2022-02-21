<%-- 
    Document   : eventList
    Created on : 9 févr. 2022, 20:01:40
    Author     : Guiro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.0.0/css/all.css">
  
</head>
<body>

<%@include file="../header.html" %>
<!-- First Container -->
<div class="container-fluid bg-1 text-center">
  <h3 class="margin">Agenda</h3>
  <img src="${pageContext.request.contextPath}/images/home.jpg" class="img-responsive img-circle margin" style="display:inline" alt="Agenda" width="350" height="350">
  <h3>Mon agenda perso</h3>
</div>

<!-- Third Container (Grid) -->
<div class="container-fluid col-9">   
    <!-- Content page -->
    <span class="margin"></span>    
    
    <c:if test="${null != message }">
        <div class="alert alert-info alert-dismissible fade show" role="alert">
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>
    <div class="position-relative margin">
        <div class="position-absolute top-0 start-50 translate-middle">
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="all" value="all" checked>
                <label class="form-check-label" for="all">
                  All
                </label>
            </div>    
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="today" value="day">
                <label class="form-check-label" for="today">
                  Today
                </label>
            </div>
            <div class="form-check form-check-inline margin">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="week" value="week">
                <label class="form-check-label" for="week">
                  This week
                </label>
            </div>
            <div class="form-check form-check-inline margin">
                <input class="form-check-input" type="radio" name="flexRadioDefault" id="month" value="month">
                <label class="form-check-label" for="month">
                  This month
                </label>
            </div>
        </div>
    </div>
        <table class="table table-striped">
            <thead>
              <tr>
                <!--<th scope="col">#</th>-->
                <th scope="col">Event Name</th>
                <th scope="col">Star date</th>
                <th scope="col">Start Time</th>
                <th scope="col">End Date</th>
                <th scope="col">End Time</th>
                <th scope="col">Location</th>
                <th scope="col">Category</th>
                <th scope="col">Priority</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach var="event" items="${ events }">
                    <tr>
                        <!--<th scope="row"><a href="#?"><c:out value="${ event.id }" /></a></th>-->
                        <td><c:out value="${ event.eventName }" /></td>
                        <td><c:out value="${ event.startDate }" /></td>
                        <td><c:out value="${ event.startTime }" /></td>
                        <td><c:out value="${ event.endDate }" /></td>
                        <td><c:out value="${ event.endTime }" /></td>
                        <td><c:out value="${ event.location }" /></td>
                        <td><c:out value="${ event.category }" /></td>
                        <td><c:out value="${ event.priority }" /></td>
                        <td>
                            <a href="/Agenda/eventdetail?id=${ event.id }"><i class="fa-solid fa-blinds-open"></i></a><br/>
                            <a href="/Agenda/addevent?id=${ event.id }"><i class="fa-solid fa-pen"></i></a><br/>
                            <a href="/Agenda/eventdelete?id=${ event.id }"><i class="fa-light fa-trash-can"></i></a><br/>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

</div>

<!-- Footer -->
<%@include file="../footer.jsp" %>
    <script>
        let filter = document.getElementById("") ;
        const btn = document.querySelector('#btn');        
        const radioButtons = document.querySelectorAll('input[name="flexRadioDefault"]');
        btn.addEventListener("click", () => {
            let selectedSize;
            for (const radioButton of radioButtons) {
                if (radioButton.checked) {
                    selectedSize = radioButton.value;
                    break;
            }
        }
            // show the output:
//            output.innerText = selectedSize ? `You selected `+selectedSize : `You haven't selected any size`;
        });
    </script>
</body>
</html>