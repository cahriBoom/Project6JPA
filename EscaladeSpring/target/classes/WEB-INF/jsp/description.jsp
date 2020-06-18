<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
    	<%@ include file="header.jsp" %>
    </head>

    <body>
		<div id="container">
			<div id="header">
				<h1>Les Amis de l'Escalade</h1>
			</div>
			<%@ include file="menu.jsp" %>
			<div id="contenu">
				<h2>Description du Secteur</h2>
				<div align="center" class="table-mg">
					<table class="table">
						<tr>
							<td scope="col">Numero</td>
							<td scope="col">Nom</td>
							<td scope="col">Hauteur</td>
							<td scope="col">Cotation</td>
						</tr>
						<c:forEach var="voie" items="${ voie }">
							<tr>
								<td><c:out value="${ voie.numero}"></c:out></td>
								<td><c:out value="${ voie.nom }"></c:out></td>
								<td><c:out value="${ voie.hauteur }"></c:out></td>
								<td><c:out value="${ voie.cotation }"></c:out></td>
							</tr>
						</c:forEach>
					</table>
					<div class="content-button">
						<c:if test = "${current != 'anonymousUser'}">
							<a href="/addVoie/${id}">Ajouter Voie</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
    </body>
</html>