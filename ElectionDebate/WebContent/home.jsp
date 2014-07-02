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
			<h1>Debates Eleitorais</h1>
		</div>

		<div class="card signin-card">

			<form action="servletDAR" method="post" name="formDebates">

				<input type="hidden" name="comando" value="ShowDebates" /> 
				<input type="submit" value="Cadastrar debate" class="rc-button rc-button-submit" />

			</form>

		</div>

	</div>

</body>
</html>