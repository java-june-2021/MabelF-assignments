<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>New Dojos</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <h1>New Dojo </h1>
                    <hr>
                    <form:form action="/dojos/addDojo" method="POST" modelAttribute="dojo">
                        <div class="form-group">
                            <!-- This needs to match what's inside model -->
                            <form:label path="name">Dojo Name: </form:label>
                            <form:errors path="name" />
                            <form:input path="name" />
                        </div>
                        <button>Create</button>
                    </form:form>

                </div>

            </body>

            </html>