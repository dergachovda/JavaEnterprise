<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title2</title>
</head>
<body>
My first web page
<c:out value="jstl out test1"/>
<%
    List<String> userNamesList = Arrays
            .asList("name1", "name2", "name3", "name4", "name5");
    response.getWriter().print(userNamesList);
    request.setAttribute("userNamesList1", userNamesList);
%>

<table border="3">
    <tr>
        <th> User Name</th>
    </tr>

    <c:forEach var="usrName" items="${userNamesList1}">

        <tr>
            <td>
                >>> ${usrName}
            </td>
        </tr>

    </c:forEach>

</table>
<a href="addUser.jsp">add_user_link</a>
</body>
</html>
