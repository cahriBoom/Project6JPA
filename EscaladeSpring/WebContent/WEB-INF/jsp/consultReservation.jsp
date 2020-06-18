<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<h2>Liste des Réservation</h2>
					<div align="center" class="table-mg">
					    <div class="table" align="center">
					    <table>
					    	<tr>
							    <td scope="col">n° du Topo</td>
							    <td scope="col">Site</td>
							    <td scope="col">Loueur</td>
							    <td scope="col">Mail</td>
							    <td scope="col">Etat</td>
							   	<td scope="col">Date de parution</td>
							   	<td scope="col">Valider</td>
							   	<td scope="col">Refuser</td>
						    	<c:forEach var="topos" items="${ topos }">
								    <tr>
								    	<td><c:out value="${ topos.id_topo}" /></td>
								    	<td><c:out value="${ topos.site.nom }" /></td>
								    	<td><c:out value="${ topos.loueur.nom }" /> </td>
								    	<td><c:out value="${ topos.loueur.mail }" /> </td>
								    	<td><c:out value="${ topos.etat }" /></td>
								    	<td><c:out value="${ topos.parution }"></c:out></td>
										<td><a href="${contextPath}/reservValidation/${topos.id_topo}">Accepter</a></td>
										<td><a href="${contextPath}/reservReject/${topos.id_topo}">Refuser</a></td>
								    </tr>
							    </c:forEach>
							</tr>
					    </table>
					    <div class="content-button">
					    	<a href="${contextPath}/welcome/${current}">Retour</a>
					    </div>
					</div>
			    </div>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
    </body>
</html>