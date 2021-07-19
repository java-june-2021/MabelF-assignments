<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Insert title here</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <h1>Album Details</h1>
                    <hr>
                    <p>Artist/Band Name: ${album.bandName} </p>
                    <p>Album Name: ${album.albumName} </p>
                    <p>Release Year: ${album.releaseYear} </p>
                    <hr>
                    <h2> Songs </h2>
                    <c:forEach items="${album.songs}" var="song">
                        <li>
                            <p>Name: ${song.name}</p>
                            <p>Song length: ${song.length}</p>
                        </li>

                    </c:forEach>
                    <!-- <c:if test="${album.label != null}">
                    <h1>Label Information</h1>
                    <p>Label Name: ${album.label.name}</p>
                    <p>Label Location: ${album.label.city}</p>
                </c:if> -->
                    <c:choose>
                        <c:when test="${album.label!=null}">
                            <h1>Label Information</h1>
                            <p>Label Name: ${album.label.name}</p>
                            <p>Label Location: ${album.label.city}</p>
                        </c:when>
                        <c:otherwise>
                            <h3>Add a label to record</h3>
                            <!-- JSTL FORM -->
                            <form:form method="POST" action="/${album.id}/addlabel" modelAttribute="label">
                                <div class="form-group">
                                    <!-- This needs to match what's inside model -->
                                    <form:label path="name"> Name: </form:label>
                                    <form:errors path="name" />
                                    <form:input path="name" />
                                </div>
                                <div class="form-group">
                                    <!-- This needs to match what's inside model -->
                                    <form:label path="city">City: </form:label>
                                    <form:errors path="city" />
                                    <form:input path="city" />
                                </div>
                                <button>Add Label</button>
                            </form:form>
                        </c:otherwise>
                    </c:choose>
                    <a href="/${album.id}/edit" class="btn btn-primary">Edit Album</a>
                    <!-- The platform does delete inside a form. Here we do something else ... -->
                    <a href="/${album.id}/delete" class="btn btn-danger">Delete Album</a>
                </div>

            </body>

            </html>