<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>New Category</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
            </head>


            <body>
                <h1>New Category</h1>
                <p>${addSuccess}</p>
                <div class="container">
                    <form:form method="POST" action="/categories/addNew" modelAttribute="category">
                        <div class="form-group">
                            <form:label path="categoryName"> Name: </form:label>
                            <form:errors path="categoryName"></form:errors>
                            <form:input class="form-control" path="categoryName"></form:input>
                        </div>
                        <input class="btn btn-primary" type="submit" value="Create" />
                    </form:form>
                </div>

            </body>

            </html>