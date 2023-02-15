<%@ page import="java.util.List" %>
<%@ page import="io.github.axel1.webquiz.model.entity.Voyage" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: axel
  Date: 15/02/2023
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Voyage> voyages = new ArrayList<>();
    if (request.getAttribute("voyages") != null) {
        voyages = (List<Voyage>) request.getAttribute("voyages");
    }
%>
<html>
<head>
    <title>Voyages</title>
</head>
<body>
<a href="index.jsp">Accueil</a>
<h1>Recherche Voyages</h1>
<form action="" method="get">
    <label for="ville">Ville</label>
    <input type="text" name="ville" id="ville">
    <input type="submit" value="Rechercher">
</form>
<table>
    <tr>
        <th>Ville</th>
        <th>Année</th>
        <th>Appréciation</th>
        <th>Internaute</th>
    </tr>
    <% for (Voyage voyage : voyages) { %>
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
