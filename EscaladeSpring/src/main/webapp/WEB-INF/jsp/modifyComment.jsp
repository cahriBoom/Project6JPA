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
				<h2>Pour les amis de l'escalade</h2>
			    <div class="form-group table-mg">       
					<form:form method="post" modelAttribute="commentaire" action="">
						<div align="center" class="input-group mb-3">
							<label for="contenu">Contenu</label>
							<form:input path="contenu" class="form-control" type="text" id="contenu" />
						</div>
						<input class="btn btn-primary mb-2" type="submit" value="Modifier" />
					</form:form>
				</div>
				<div class="content-button" align="center">
					<a href="../accueil">Retour Accueil</a>
				</div>
			</div>
		</div>
	</body>
</html>