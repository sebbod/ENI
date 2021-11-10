<%@page import="fr.eni.javaee.module3.tp2.bo.ActionsPossibles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    	isErrorPage="false"
    	errorPage="pageErreurExecutionJSP.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jouez au chifoumi</title>
</head>
<body>
	<h1>Jouez!</h1>
	<a href="<%=request.getContextPath()%>/modules/module3/tp2/ServletChifoumi?choix=<%=ActionsPossibles.CHI%>">
		<img width="75" src="<%=request.getContextPath()%>/modules/module3/images/chi.png"/>
	</a>
	<a href="<%=request.getContextPath()%>/modules/module3/tp2/ServletChifoumi?choix=<%=ActionsPossibles.FOU%>">
		<img width="75"  src="<%=request.getContextPath()%>/modules/module3/images/fou.png"/>
	</a>
	<a href="<%=request.getContextPath()%>/modules/module3/tp2/ServletChifoumi?choix=<%=ActionsPossibles.MI%>">
		<img width="75"  src="<%=request.getContextPath()%>/modules/module3/images/mi.png"/>
	</a>
	
	<h1>Jouez!</h1>
	<form action="<%=request.getContextPath()%>/modules/module3/tp2/ServletChifoumi" method="post">
		<ul>
			<li>
				<label for="choix<%=ActionsPossibles.CHI%>"><img width="75"  src="<%=request.getContextPath()%>/modules/module3/images/chi.png"/></label>
				<input type="radio" id="choix<%=ActionsPossibles.CHI%>" name="choix" value="<%=ActionsPossibles.CHI%>"/>
			</li>
			<li>
				<label for="choix<%=ActionsPossibles.FOU%>"><img width="75"  src="<%=request.getContextPath()%>/modules/module3/images/fou.png"/></label>
				<input type="radio" id="choix<%=ActionsPossibles.FOU%>" name="choix" value="<%=ActionsPossibles.FOU%>"/>
			</li>
			<li>
				<label for="choix<%=ActionsPossibles.MI%>"><img width="75"  src="<%=request.getContextPath()%>/modules/module3/images/mi.png"/></label>
				<input type="radio" id="choix<%=ActionsPossibles.MI%>" name="choix" value="<%=ActionsPossibles.MI%>"/>
			</li>
		</ul>
		<input type="submit" value="Valider">
	</form>
	<%
	String maVariable=null;
	maVariable.length();//NullPointerException
	%>
</body>
</html>








