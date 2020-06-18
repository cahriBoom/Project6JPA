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
            <div class="contenu">
				<h2>Pour les amis de l'escalade</h2>
				<form:form method="post" modelAttribute="site" action="">
				    <div align="center" class="table-mg">
						<div class="form-check">
							<c:forEach var="sites" items="${ sites }">
								<form:radiobutton class="form-check-input" id="radiobtn" value="${ sites.nom }" path="nom" />
								<label class="form-check-label" for="radiobtn">
									${ sites.nom }
								</label>
								<br />
							</c:forEach>
							<button type="submit" class="btn btn-primary mb-2">Ajouter</button>
						</div>
				    </div>
				    <div align="center" class="content-button">
						<a href="${contextPath}/accueil"> Retour Accueil</a>
						<a href="${contextPath}/topo"> Retour Topos</a>
					</div>
				</form:form>
			</div>
		</div>
    </body>
</html>