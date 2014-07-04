<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" errorPage="error-pages/error.html" %>

<html>
<head>
<meta charset="UTF-8">
<title>Debate Eleitoral</title>

	<link rel="stylesheet" type="text/css" href="resources/style/home-style.css" />
<script src="./resources/scripts/jquery.js" type="text/javascript"></script>
<script src="./resources/scripts/jquery-ajax.js" type="text/javascript"></script>
</head>
<body class="ui-mobile-viewport">

	<div id="content-page" class="">

		<div id="header">
			<h1>${debate.nome}</h1>
		</div>

		<div class="card signin-card">

			<div style="background: #F1F0F5;" >
				<p>Descrição : ${debate.descricao}<p>
				<p>Data : ${debate.data}<p>
				
				<ul>
					<c:forEach var="candidato" items="${debate.candidatos }" >
						<li> ${candidato.nome} </li>
					</c:forEach>
				</ul>
			</div>			
			
			
			
		</div>

	</div>

</body>
</html>