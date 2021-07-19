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
                <table class="table table-dark">
                    <!-- Example: Burbank location ninjas -->
                    <h1>${dojo.name} Location Ninjas</h1>
                    <thead>
                        <tr>
                            <th> First Name</th>
                            <th> Last Name</th>
                            <th> Age </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ninjas}" var="ninja">
                            <tr>
                                <td>${ninja.firstName}</td>
                                <td>${ninja.lastName}</td>
                                <td>${ninja.age}</td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </body>

            </html>