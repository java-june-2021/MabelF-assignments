<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>New Question</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container">
                    <h1>Question: ${question.text}</h1>
                    <h2>Tags:
                        <c:forEach items="${question.tags}" var="tag" varStatus="loop">
                            <c:choose>
                                <c:when test="${loop.index == question.tags.size() - 1}">
                                    ${tag.subject}
                                </c:when>
                                <c:otherwise>
                                    ${tag.subject},
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </h2>
                    <!-- <h1>Answers:</h1> -->
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Answers</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${question.answers}" var="answer">
                                <tr>
                                    <td>
                                        ${answer.text}
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h2>Add your answer here:</h2>
                    <form:form method="POST" action="/questions/${question.id}" modelAttribute="answer">
                        <div class="form-group">
                            <form:label path="text"> Answer: </form:label>
                            <form:errors path="text"></form:errors>
                            <form:textarea class="form-control" path="text"></form:textarea>
                        </div>

                        <input class="btn btn-primary" type="submit" value="Answer it!" />
                    </form:form>
                </div>

            </body>

            </html>