<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Welcome to Records dot Com</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <h1>Welcome to records dot com</h1>
                    <div class="row">
                        <div class="col">
                            <h3> Login </h3>
                            <p>${loginError}</p>
                            <form method="POST" action="/login">
                                <div class="form-group">
                                    <label>Email:</label>
                                    <input type="email" name="lemail">
                                </div>
                                <div class="form-group">
                                    <label>Password:</label>
                                    <input type="password" name="lpassword">
                                </div>
                                <button>Login</button>
                            </form>
                        </div>
                        <div class="col">
                            <h3> Register </h3>
                            <form:form method="POST" action="/register" modelAttribute="user">
                                <div class="form-group">
                                    <form:label path="firstName"> First Name </form:label>
                                    <form:errors path="firstName"></form:errors>
                                    <form:input class="form-control" path="firstName"></form:input>
                                </div>

                                <div class="form-group">
                                    <form:label path="lastName"> Last Name </form:label>
                                    <form:errors path="lastName"></form:errors>
                                    <form:input class="form-control" path="lastName"></form:input>
                                </div>

                                <div class="form-group">
                                    <form:label path="email"> Email </form:label>
                                    <form:errors path="email"></form:errors>
                                    <form:input type="email" class="form-control" path="email"></form:input>
                                </div>

                                <div class="form-group">
                                    <form:label path="password"> Password </form:label>
                                    <form:errors path="password"></form:errors>
                                    <form:input type="password" class="form-control" path="password"></form:input>
                                </div>

                                <div class="form-group">
                                    <form:label path="confirmPassword"> Confirm Password </form:label>
                                    <form:errors path="confirmPassword"></form:errors>
                                    <form:input type="password" class="form-control" path="confirmPassword" />
                                </div>
                                <input class="btn btn-primary" type="submit" value="Submit" />
                            </form:form>
                        </div>
                    </div>
                </div>

                <!-- Old Janky Login -->
                <!-- <form method="POST" action="/login">
                    <select name="userToLogin">
                        <c:forEach items="${users}" var="user">
                            <option value="${user.id}">${user.firstName} ${user.lastName}</option>
                        </c:forEach>
                    </select>
                    <button>Login</button>

                </form> -->
            </body>

            </html>