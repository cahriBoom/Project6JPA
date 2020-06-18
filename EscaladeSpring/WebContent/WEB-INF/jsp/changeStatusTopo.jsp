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
				<div align="center">
					 <h2>Le Topo est maintenant Disponible</h2>
				</div>
			</div>
			<a href="${contextPath}/accueil">Retour Accueil</a>
		</div>
		<%@ include file="footer.jsp" %>
    </body>
</html>