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
			<div id="contenu">
				<h2>Liste des Sites</h2>
				<div align="center">
					<div class="table-mg">
						<table class="table">
							<tr>
								<td scope="col">Nom</td>
								<td scope="col">Ville</td>
								<td scope="col">Nombre de Secteurs</td>
								<td scope="col">Commentaires</td>
							<c:forEach var="site" items="${ site }">
							<c:if test="${site.favoris==0}">
								<tr>
									<td><a href ="${ contextPath }/secteur/${ site.id }"><c:out value="${ site.nom }" /></a></td>
									<td><c:out value="${ site.ville }" /></td>
									<td><c:out value="${ site.nb }"></c:out></td>
									<td><a href="${contextPath}/commentaire/${ site.id }"> ${ site.nb_commentaire }</a></td>
								</tr>
							</c:if>
							</c:forEach>
							</tr>
						</table>
					</div>
					<div class="content-button">
						<c:if test = "${current != 'anonymousUser'}">
							<a href="${contextPath}/addSite">Ajouter Site</a>
						</c:if>
					</div>
					<h2>Liste des Sites Officiels</h2>
					<div class="table-mg">
						<table class="table">
							<tr>
								<td scope="col">Nom</td>
								<td scope="col">Ville</td>
								<td scope="col">Nombre de Secteurs</td>
								<td scope="col">Commentaires</td>
							    <c:forEach var="site" items="${ site }">
									<c:if test="${site.favoris==1}">
									<tr>
										<td><a href ="${ contextPath }/secteur/${ site.id }"><c:out value="${ site.nom }" /></a></td>
									    <td><c:out value="${ site.ville }" /></td>
									    <td><c:out value="${ site.nb }"></c:out></td>
									    <td><a href="${contextPath}/commentaire/${ site.id }"> ${ site.nb_commentaire }</a></td>
									</tr>
									</c:if>
								</c:forEach>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
			<%@ include file="footer.jsp" %>
    </body>
</html>