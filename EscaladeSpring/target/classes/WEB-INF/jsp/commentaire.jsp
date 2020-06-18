<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<h2>Pour les amis de l'escalade</h2>	
					<div align="center" class="table-mg">
					<table class="table">
						<tr>
							<td scope="col">Date</td>
							<td scope="col">Contenu</td>
							<td scope="col">Utilisateur</td>
							<c:if test = "${current == 'ShieldDirector@gmail.com'}">
								<td scope="col">Modifier</td>
								<td scope="col">Supprimer</td>
							</c:if>
						</tr>
						<c:forEach var="commentaire" items="${ commentaire }">
							<tr>
								<td><c:out value="${ commentaire.date}"></c:out></td>
								<td><c:out value="${ commentaire.contenu }"></c:out></td>
								<td><c:out value="${ commentaire.user.nom }"></c:out></td>
								<c:if test = "${current == 'ShieldDirector@gmail.com'}">
									<td><a href="/modifyComment/${commentaire.id}">Modifier</a></td>
									<td><a href="/supprComment/${commentaire.id}">Supprimer</a></td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
					<div class="content-button">
						<c:if test = "${current != 'anonymousUser'}">
							<a href="/addComments/${id}">Ajouter commentaire</a>
						</c:if>
						<a href="../accueil"> Retour Accueil</a>
						<a href="../liste">Retour Site</a>
					</div>
				</div>
			</div>
		</div>
    </body>
</html>