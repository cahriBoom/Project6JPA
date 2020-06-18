<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<c:if test="${not empty error}">
					<div class="msg">${error}</div>
				</c:if>
				<form:form method="post" modelAttribute="voie" action="">
					<div align="center" class="table-mg">
						<label for="name">Nom</label>
						<form:input type="text" required="required" class="form-control" name="name" path="nom" placeholder="Nom"/>
						<br />
						<label for="cotation">Cotation</label>
						<form:input type="text" required="required" class="form-control" name="cotation" path="cotation" placeholder="Cotation"/>
						<br />
						<label for="hauteur">Hauteur</label>
						<form:input type="text" required="required" class="form-control" name="hauteur" path="hauteur" placeholder="Hauteur"/>
					</div>
					<button class="btn btn-primary mb-2" id="button-id" type="submit">Ajouter Voie</button>
				</form:form>
			</div>
			<div class="content-button" align="center">
				<a href="${contextPath}/accueil"> Retour Accueil</a>
				<a href="${contextPath}/description/${id}"> Retour Voies</a>
			</div>
		</div>
    </body>
</html>