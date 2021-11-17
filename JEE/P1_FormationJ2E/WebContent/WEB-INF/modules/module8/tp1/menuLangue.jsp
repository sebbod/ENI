<p>
	<fmt:message key="msg.langueactuelle"></fmt:message>:${!empty sessionScope.langue?sessionScope.langue:pageContext.request.locale}
</p>
<p>
	<fmt:message key="msg.choisirlangue"></fmt:message>:
	<a href="${pageContext.request.contextPath}/modules/module8/tp1/choixlangue?langue=fr">Français</a>
	<a href="${pageContext.request.contextPath}/modules/module8/tp1/choixlangue?langue=en">English</a>
	<a href="${pageContext.request.contextPath}/modules/module8/tp1/choixlangue"><fmt:message key="msg.languenavigateur"/></a>
	
</p>