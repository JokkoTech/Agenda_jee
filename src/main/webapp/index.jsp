<%-- 
    Document   : index
    Created on : 16 févr. 2022, 16:23:46
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <title>Login</title>
    </head>
    <body>
        <div class="login-form-bg h-100 mt-5">
            <div class="container h-100">
                <div class="row justify-content-center h-100">
                    <div class="col-xl-6">
                        <div class="form-input-content">
                            <div class="card login-form mb-0">
                                <div class="card-body pt-5">
                                    <h4 class="text-center">G-Agenda</h4>
                                    <c:if test="${error != null || not empty error }">
                                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                                            <strong>Ooop!</strong> ${error}.
                                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                        </div>
                                    </c:if>
                                    <div class="mt-5 mb-5 login-input">
                                    <form action="" method="post" class="row g-3 needs-validation">
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="text" name="email" class="form-control" id="email" placeholder="Email..." value="${email}">
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
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
