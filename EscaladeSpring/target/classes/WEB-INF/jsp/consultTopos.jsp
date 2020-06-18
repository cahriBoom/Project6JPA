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
				<h2>Liste des Topos</h2>
				    <div align="center" class="table-mg">
					    <table class="table">
					    	<tr>
							    <td scope="col">n° du Topo</td>
							    <td scope="col">Site</td>
							    <td scope="col">Disponible</td>
							   	<td scope="col">Date de parution</td>
							   	<td scope="col">Status</td>
						    	<c:forEach var="owned" items="${ owned }">
							    	<tr>
							    		<td><c:out value="${ owned.id_topo}" /></td>
							    		<td><c:out value="${ owned.site.nom }" /></td>
							    		<td><c:out value="${ owned.etat }" /></td>
							    		<td><c:out value="${ owned.parution }"></c:out></td>
							    		<td><a href="../changeStatusTopo/${owned.id_topo}">Changer Status</a></td>
							    	</tr>
							    </c:forEach>
							</tr>
						</table>
					<div class="content-button">
						<a href="/welcome/${current}">Retour</a>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
    </body>
</html>