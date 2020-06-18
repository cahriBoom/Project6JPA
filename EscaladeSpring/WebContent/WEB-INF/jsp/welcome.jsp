<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  				<div class="table-mg content-button" align="center">            
					<h2>Pour les amis de l'escalade</h2>
					<h2>Bienvenue sur le site internet, ${prenom}</h2> <br /> 
					<a href="${contextPath}/consultTopos/${ current }">Consulter mes topos</a> <br /> <br />
					<a href="${contextPath}/consultReservation/${ current }">consulter demande de réservation</a> <br /> <br />
				</div>
				<div class="content-button" align="center">	
					<a href="${contextPath}/accueil"> Retour Accueil</a>
				</div>
			</div>
		</div>
	<%@ include file="footer.jsp" %>
    </body>
</html>