<%--
  Created by IntelliJ IDEA.
  User: axel
  Date: 15/02/2023
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Erreur</title>
</head>
<body>
<h1>Erreur !</h1>
<p style="color: red;"><%= request.getAttribute("error") %></p>
</body>
</html>
