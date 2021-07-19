<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Edit this Album (prepopulated fields)</title>
            </head>

            <body>
                <div class="container">
                    <h1>Add A new Album </h1>
                    <hr>
                    <!-- This is copy pasted from new but the action is different.  -->
                    <!-- album.id/edit is more restful than the other way around. -->
                    <!-- Apparently the portal does it diffrently. This is the in-class version. -->
                    <form:form action="/${album.id}/edit" method="POST" modelAttribute="album">
                        <div class="form-group">
                            <!-- This needs to match what's inside model -->
                            <form:label path="bandName">Band Name: </form:label>
                            <form:errors path="bandName" />
                            <form:input path="bandName" />
                        </div>
                        <div class="form-group">
                            <!-- This needs to match what's inside model -->
                            <form:label path="albumName">Album Name: </form:label>
                            <form:errors path="albumName" />
                            <form:input path="albumName" />
                        </div>
                        <div class="form-group">
                            <!-- This needs to match what's inside model -->
                            <form:label path="releaseYear">Release Year: </form:label>
                            <form:errors path="releaseYear" />
                            <form:input path="releaseYear" />
                        </div>
                        <button>Edit Album</button>
                    </form:form>
                </div>

            </body>

            </html>