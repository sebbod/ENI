<h3>Voici les informations lues dans le fichier fragmentIncluAvecBaliseInclude.jsp</h3>
<p>

<%
	String bonjour = "bonjour tout le monde";
%>
	<%=bonjour %>
</p>

<%--<%=variableUtiliseeDansFragment%>Erreur de compilation--%>

<p>
	Lecture du paramètre "parametre" :
	<%=request.getParameter("parametre") %>
</p>

<p>
	Lecture de l'attribut "attribut" :
	<%=request.getAttribute("attribut") %>
</p><html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882"><head>
<!--[if gte mso 9]><xml>
<mso:CustomDocumentProperties>
<mso:_dlc_DocId msdt:dt="string">Z5HNVW24N33T-678105430-3905</mso:_dlc_DocId>
<mso:_dlc_DocIdItemGuid msdt:dt="string">fb5bb3ea-25f5-4b94-805a-e38ee78480b1</mso:_dlc_DocIdItemGuid>
<mso:_dlc_DocIdUrl msdt:dt="string">http://inet/eni-transverse/ecole-numérique/_layouts/15/DocIdRedir.aspx?ID=Z5HNVW24N33T-678105430-3905, Z5HNVW24N33T-678105430-3905</mso:_dlc_DocIdUrl>
</mso:CustomDocumentProperties>
</xml><![endif]-->
</head>