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
					<form:form method="post" modelAttribute="commentaire" action="">
						<div align="center" class="input-group mb-3">
							<form:input type="text" class="form-control" required="required"  placeholder="Commentaire" aria-label="Commentaire" aria-describedby="basic-addon2" path="contenu"/>
							<div class="input-group-append">
								<button class="btn btn-primary mb-2" type="submit">Ajouter</button>
							</div>
						</div>
					</form:form>
				</div>
				<div class="content-button">			
					<a href="../accueil"> Retour Accueil</a>
					<a href="../commentaire/${id}">Retour Commentaire</a>
				</div>
			</div> 
		</div>
    </body>
</html>