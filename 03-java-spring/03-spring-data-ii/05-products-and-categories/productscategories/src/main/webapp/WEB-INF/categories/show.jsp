<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Category Page</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
            </head>



            <body>
                <div class="container">
                    <h1>${category.categoryName}</h1>
                    <h3>Products in ${category.categoryName}:</h3>
                    <ul>
                        <c:forEach items="${productsin}" var="prod">
                            <li>${prod.productName}</li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="container">
                    <h3>Add Product Here:</h3>
                    <form method="POST" action="/categories/${category.id}">
                        <select class="form-select" name="newProd">
                            <c:forEach items="${allproducts}" var="product">
                                <c:choose>
                                    <c:when test="${!productsin.contains(product)}">
                                        <option value="${product.id}">${product.productName}</option>
                                    </c:when>
                                    <c:otherwise>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                        <button class="btn btn-primary">Add</button>

                </div>

            </body>

            </html>