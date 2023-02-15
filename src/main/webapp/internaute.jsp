<%@ page import="io.github.axel1.webquiz.model.entity.Internaute" %>
<%@ page import="io.github.axel1.webquiz.model.entity.Voyage" %><%--
  Created by IntelliJ IDEA.
  User: axel
  Date: 15/02/2023
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Internaute internaute = (Internaute) request.getAttribute("internaute");
%>
<html>
<head>
    <title>Internaute</title>
</head>
<body>
<a href="index.jsp">Accueil</a>
<h1>Bonjour <%= internaute.getNom() %></h1>
<a href="formVoyage.html">Nouveau Voyage</a>
<h2>Mes Voyages</h2>
<table>
    <tr>
        <th>Ville</th>
        <th>Année</th>
        <th>Appréciation</th>
        <th>Internaute</th>
    </tr>
    <% for (Voyage voyage : internaute.getVoyages()) { %>
    <tr>
        <td><%= voyage.getVille() %></td>
        <td><%= voyage.getDateDepart() %></td>
        <td><%= voyage.getAppreciation().getAppreciation() %></td>
        <td><%= voyage.getInternaute().getNom() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
