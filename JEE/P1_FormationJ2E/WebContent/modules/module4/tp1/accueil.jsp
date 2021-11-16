<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=request.getContextPath() %>/css/style_m4tp1.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
</head>
<body>
	<h1>ACCUEIL</h1>
	
	<div class="contenu">
		<a href="<%=request.getContextPath()%>/modules/module4/tp1/ajoutrepas"><input type="button" value="Ajouter un nouveau repas"/></a>
	</div>
	<div class="contenu">
		<a href="<%=request.getContextPath()%>/modules/module4/tp1/repas"><input type="button" value="Visualiser les repas"/></a>
	</div>
</body>
</html>