<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Product Page</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
            </head>



            <body>
                <div class="container">
                    <h1>${product.productName}</h1>
                    <h3>Categories of ${product.productName}:</h3>
                    <ul>
                        <c:forEach items="${categoriesin}" var="category">
                            <li>${category.categoryName}</li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="container">
                    <h3>Add Category Here:</h3>
                    <form method="POST" action="/products/${product.id}">
                        <select class="form-select" name="newCat">
                            <c:forEach items="${allcategories}" var="category">
                                <c:choose>
                                    <c:when test="${!categoriesin.contains(category)}">
                                        <option value="${category.id}">${category.categoryName}</option>
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