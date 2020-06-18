<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="right">
	<c:set var = "current" scope = "session" value = "${ current }"/>
	<c:if test = "${current != 'anonymousUser'}">
		<a href="${contextPath}/welcome/${ current }"> Profil </a>
		<a href="<c:url value="${contextPath}/logout" />">Logout</a>
	</c:if>
	<c:if test = "${current == 'anonymousUser'}">
		<a href="${contextPath}/connexion">Connexion</a>
		<a href="${contextPath}/inscription">Inscription</a>
	</c:if>
</div>
