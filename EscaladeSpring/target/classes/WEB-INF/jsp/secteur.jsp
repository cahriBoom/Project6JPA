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
				<h2>Liste des Secteurs</h2>
				<div align="center" class="table-mg">
					<table class="table">
						<tr>
							<td scope="col">Nom</td>
							<td scope="col">Nombre de voies</td>
						</tr>
						<c:forEach var="secteur" items="${ secteur }">
							<tr>
								<td><a href ="../description/${ secteur.id }"><c:out value="${ secteur.nom }"></c:out></a></td>
								<td><c:out value="${ secteur.nb }"></c:out></td>
							</tr>
						</c:forEach>
					</table>
					<div class="content-button">
						<c:if test = "${current != 'anonymousUser'}">
							<a href="/addSecteur/${id}">Ajouter Secteur</a>
						</c:if>
						<a href="/liste">Retour Site</a>
					</div>
					<div class="content-button">
						<c:if test = "${current == 'ShieldDirector@gmail.com'}">
							<a href="/validationOfficial/${id}">Site Officiel "Amis de l'escalade"</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
    </body>
</html>