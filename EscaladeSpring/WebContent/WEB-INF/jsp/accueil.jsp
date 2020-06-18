<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
    <head>
    	<%@ include file="header.jsp" %>
    </head>
	<div class="container">
		<div id="header">
			<h1>Les Amis de l'Escalade</h1>
		</div>
		<%@ include file="menu.jsp" %>
		   <div class="row">
			  <div id="conteneur">
				<section>
				<article>                
					<h2>Pour les amis de l'escalade</h2>
					<p>Bienvenue sur le site internet des Amis de l'escalade.</p>
				</article>
				</section>
			  </div>
		   </div>
		</div>
	<%@ include file="footer.jsp" %>
	</body>
</html>