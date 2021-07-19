<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!-- Inspired by song.jsp -->
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>New Ninja</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
            </head>

            <body>
                <!-- An dojo is required. You can either set a hidden form or keep it on the backend.  -->
                <!-- TODO -->
                <div class="container">
                    <h1>New Ninja</h1>
                    <hr>
                    <form:form method="POST" action="/ninjas/add" modelAttribute="ninja">
                        <div class="form-group">
                            <form:label path="dojo"> Dojo: </form:label>
                            <form:errors path="dojo" />
                            <form:select path="dojo">
                                <!-- Create the dropdown list -->
                                <c:forEach items="${dojos}" var="d">
                                    <option value="${d.id}">${d.name} </option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <!-- Making the rest of the form... -->
                        <div class="form-group">
                            <form:label path="firstName"> First Name: </form:label>
                            <form:errors path="firstName" />
                            <form:input path="firstName" />
                        </div>
                        <div class="form-group">
                            <form:label path="lastName"> Last Name: </form:label>
                            <form:errors path="lastName" />
                            <form:input path="lastName" />
                        </div>
                        <div class="form-group">
                            <form:label path="Age"> Age: </form:label>
                            <form:errors path="Age" />
                            <form:input path="Age" />
                        </div>
                        <button>Create</button>

                    </form:form>
            </body>

            </html>