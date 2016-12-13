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
        First name:&nbsp
        <input name="name"      type="text" value=""/>
        </br>

        Last Name:&nbsp
        <input name="sur_name"  type="text" value=""/>
        </br>

        Login:&nbsp
        <input name="login"     type="text" value=""/>
        </br>

        Password:&nbsp
        <input name="password"  type="text" value=""/>
        </br>

        Age:&nbsp
        <input name="age"       type="text" value=""/>
        </br>

        Phone:&nbsp
        <input name="phone"     type="text" value=""/>
        </br>

        Email:&nbsp
        <input name="email"     type="text" value=""/>
        </br>

        Address:&nbsp
        <input name="address"   type="text" value=""/>
        </br>

        <input type="submit" value="add user"/>

    </form>>

</body>

</html>
