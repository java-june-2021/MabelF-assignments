<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <!DOCTYPE html>
            <html>

            <head>

                <meta charset="ISO-8859-1">
                <title>Insert title here</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">


            </head>

            <body>
                <a href="/languages/">Dashboard</a>
                <div class="container">
                    <p>${language.name}</p>
                    <p>${language.creator}</p>
                    <p>${language.currentVersion}</p>

                </div>
                <div>
                    <a href="/languages/edit/${language.id}">Edit</a>
                    <a href="/languages/delete/${language.id}" method="DELETE">Delete</a>
                </div>
            </body>

            </html>