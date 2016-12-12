<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<%
    List<String> userNamesList = Arrays
            .asList("name1", "name2", "name3", "name4", "name5");
    response.getWriter().print(userNamesList);
    request.setAttribute("userNamesList1", userNamesList);
%>
<body>
    <form method="post" action="<%=request.getContextPath()%>/users">
        <input name="login" type="text" value=""/>
        <input name="password" type="text" value=""/>
        <input name="age" type="text" value=""/>
        <input type="submit" value="add user"/>
    </form>>
</body>
</html>
