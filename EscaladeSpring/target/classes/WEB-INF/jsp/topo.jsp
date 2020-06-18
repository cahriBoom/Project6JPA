<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<h1>Liste des Topos</h1>
				<div align="center" class="table-mg">
					<table class="table">
						<tr>
							<td scope="col">n° du Topo</td>
							<td scope="col">Site</td>
							<td scope="col">Propriétaire</td>
							<td scope="col">Date de parution</td>
							<td scope="col">Demande de location</td>
						 	<c:forEach var="topos" items="${ topos }">
							<tr>
								<td><c:out value="${ topos.id_topo}" /></td>
								<td><c:out value="${ topos.site.nom }" /></td>
								<td><c:out value="${ topos.createur.nom }"></c:out></td>
								<td><c:out value="${ topos.parution }"></c:out></td>
								<td><a href="/reservTopo/${topos.id_topo}">Réserver</a></td>
							</tr>
							</c:forEach>
						</tr>
					</table>
					<div class="content-button">
						<a href="/addTopo">Ajouter Topo</a>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
    </body>
</html>