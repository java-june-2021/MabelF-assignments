<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Questions Dashboard</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <h1>Questions Dashboard</h1>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Question</th>
                                <th scope="col">Tags</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${allquestions}" var="ques">
                                <tr>
                                    <td><a href="/questions/${ques.id}">${ques.text} </a></td>
                                    <td>

                                        <c:forEach items="${ques.tags}" var="tag" varStatus="loop">
                                            <c:choose>
                                                <c:when test="${loop.index == ques.tags.size() - 1}">
                                                    ${tag.subject}
                                                </c:when>
                                                <c:otherwise>
                                                    ${tag.subject},
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <a href="/questions/new">Add Question</a>
                </div>

            </body>

            </html>