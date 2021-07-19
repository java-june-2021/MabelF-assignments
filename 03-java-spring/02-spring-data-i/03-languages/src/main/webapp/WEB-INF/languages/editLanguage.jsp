<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

            <!DOCTYPE html>
            <html>

            <head>

                <meta charset="ISO-8859-1">
                <title> A list of programming languages </title>

                <title>Insert title here</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">


            </head>

            <body>
                <div class="container">
                    <!-- Create links -->
                    <a href="/languages/delete/${language.id}" method="DELETE">Delete</a>
                    <a href="/languages/">Dashboard</a>
                    <hr>
                </div>
                <div class="d-flex align-items-center flex-column justify-content-center h-100 bg-dark text-white">
                    <hr>
                    <!-- <%-- modelAttribute attribute is the key which specifies a name of the model object that backs this form --%> -->
                    <form:form action="/languages/edit/${language.id}" method="POST" modelAttribute="language">
                        <div class="form-group">
                            <!-- This needs to match what's inside model -->
                            <form:label path="name"> Name: </form:label>
                            <form:errors path="name" />
                            <form:input path="name" class="form-control form-control-lg" />
                        </div>
                        <div class="form-group">
                            <!-- This needs to match what's inside model -->
                            <form:label path="creator">Creator: </form:label>
                            <form:errors path="creator" />
                            <form:input path="creator" class="form-control form-control-lg" />
                        </div>
                        <div class="form-group">
                            <!-- This needs to match what's inside model -->
                            <form:label path="currentVersion"> Current Version: </form:label>
                            <form:errors path="currentVersion" />
                            <form:input path="currentVersion" class="form-control form-control-lg" />
                        </div>
                        <button class="btn btn-info btn-lg btn-block">Submit!</button>
                    </form:form>
                </div>

            </body>

            </html>