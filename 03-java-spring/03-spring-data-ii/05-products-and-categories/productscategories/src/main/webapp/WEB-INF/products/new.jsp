<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>New Product</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
            </head>


            <body>
                <h1>New Product</h1>
                <p>${addSuccess}</p>
                <div class="container">
                    <form:form method="POST" action="/products/addNew" modelAttribute="product">
                        <div class="form-group">
                            <form:label path="productName"> Name: </form:label>
                            <form:errors path="productName"></form:errors>
                            <form:input class="form-control" path="productName"></form:input>
                        </div>

                        <div class="form-group">
                            <form:label path="productDescription"> Description: </form:label>
                            <form:errors path="productDescription"></form:errors>
                            <form:textarea class="form-control" path="productDescription"></form:textarea>
                        </div>

                        <div class="form-group">
                            <form:label path="productPrice"> Price (no $ sign, no commas or else error): </form:label>
                            <form:errors path="productPrice"></form:errors>
                            <form:input class="form-control" path="productPrice" type="text" pattern="\d+.*\d*" />

                        </div>

                        <input class="btn btn-primary" type="submit" value="Create" />
                    </form:form>
                </div>

            </body>

            </html>