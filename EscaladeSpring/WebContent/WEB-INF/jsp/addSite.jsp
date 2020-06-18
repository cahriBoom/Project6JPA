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
				<h2>Pour les amis de l'escalade</h2>
			    <div class="table-mg">       
					<form:form method="post" modelAttribute="site" action="/addSite">
						<div align="center" class="input-group mb-3">
							<form:input type="text" class="form-control" required="required" placeholder="Nom du Site" aria-label="Nom du Site" aria-describedby="basic-addon2" path="nom"/>
							<br />
							<form:input type="text" class="form-control" required="required" placeholder="Ville du Site" aria-label="Ville du Site" aria-describedby="basic-addon2" path="ville"/>
							<br />
						</div>
						 <button class="btn btn-primary mb-2" type="submit">Ajouter Site</button>
						 <br />
					</form:form>
				</div>
				<div class="content-button">
					<a href="${contextPath}/accueil"> Retour Accueil</a>
					<a href="${contextPath}/liste"> Retour Site</a>
				</div>
			</div>
		</div>
	</body>
</html>