<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Debate Eleitoral</title>

<link rel="stylesheet" type="text/css"
	href="resources/style/home-style.css" />

</head>
<body class="ui-mobile-viewport">

	<div id="content-page" class="">

		<div id="header">
			<h1>Debates Eleitorais</h1>
		</div>

		<div class="card signin-card">
			<c:forEach var="debate" items="${debates}">
				<ul>
					<li>
						<h1>${debate.nome}</h1>
					</li>
				</ul>
			</c:forEach>

			<form action="ServletDAR" method="post" name="formDebates">
				<input type="hidden" name="comando" value="RegisterDebates" /> 
				<input type="submit" value="Cadastrar debate" class="rc-button rc-button-submit" />
			</form>

		</div>

	</div>

</body>
</html>