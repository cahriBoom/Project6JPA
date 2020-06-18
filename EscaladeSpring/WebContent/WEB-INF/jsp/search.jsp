<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />

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
			<div id="contenu" class="form-group table-mg">
				<form:form method="post" modelAttribute="search" action="">
					<td>
						<form:input class="form-control" type="text" path="mot" />
						<button class="btn btn-primary" type="submit">Search</button>
					</td>
				</form:form>  
				<h1>Résultat de Recherche</h1>
				<div align="center" class="table-mg">
					<c:choose>
						<c:when test="${not empty site}">
						<table class="table">
							<tr>
								<td scope="col">Nom</td>
								<td scope="col">Ville</td>
								<td scope="col">Description</td>
							</tr>
						<c:forEach var="site" items="${ site }">
							<tr>
								<td><c:out value="${ site.nom }" /></td>
								<td><c:out value="${ site.ville }" /></td>
								<td><a href ="${ contextPath }/description/${ site.id }">Voir la fiche</a></td>
							</tr>
						</c:forEach>	
						</table>
						</c:when>
						<c:when test="${not empty voie}">
						<table class="table">
							<tr>
								<td scope="col">Nom</td>
								<td scope="col">Numero</td>
								<td scope="col">Hauteur</td>
								<td scope="col">Cotation</td>
								<td scope="col">Description</td>
							</tr>
						<c:forEach var="voie" items="${ voie }">
							<tr>
								<td><c:out value="${ voie.nom }" /></td>
								<td><c:out value="${ voie.numero }" /></td>
								<td><c:out value="${ voie.hauteur }" /></td>
								<td><c:out value="${ voie.cotation }" /></td>
								<td><a href ="${ contextPath }/description/${ voie.secteur.id }">Voir la fiche</a></td>
							</tr>
						</c:forEach>
						</table>
						</c:when>
						<c:otherwise>
						<table class="table">
							<tr>
								<td scope="col">Nom</td>
								<td scope="col">Numero</td>
								<td scope="col">Decription</td>
							</tr>
						<c:forEach var="secteur" items="${ secteur }">
							<tr>
								<td><c:out value="${ secteur.nom }" /></td>
								<td><c:out value="${ secteur.nb }" /></td>
								<td><a href ="${ contextPath }/description/${ secteur.id }">Voir la fiche</a></td>
							</tr>
						</c:forEach>
						</table>
						</c:otherwise>
					</c:choose>
				</div> 
			</div>
		</div>
    </body>
</html>