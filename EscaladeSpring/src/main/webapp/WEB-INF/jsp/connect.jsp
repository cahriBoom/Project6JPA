<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="right">
	<c:set var = "current" scope = "session" value = "${ current }"/>
	<c:if test = "${current != 'anonymousUser'}">
		<a href="/welcome/${ current }"> Profil </a>
		<a href="<c:url value="/logout" />">Logout</a>
	</c:if>
	<c:if test = "${current == 'anonymousUser'}">
		<a href="/connexion">Connexion</a>
		<a href="/inscription">Inscription</a>
	</c:if>
</div>
