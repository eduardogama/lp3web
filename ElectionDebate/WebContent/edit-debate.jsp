<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			
			<form action="ServletDAR" method="post" name="formDebates">
				<label for="nome">Nome:</label>
				<input name="nome" id="nome" value="<c:out value="${debate.nome}" />" placeholder="nome" type="text"/>			
				<br />
				<label for="descricao" >Descricao:</label>
				<input name="descricao" id="descricao" value="<c:out value="${debate.descricao}" />" placeholder="descricao" type="text"/>
				<br />
				<label for="data" >Data:</label>
				<input name="data" id="data" value="<c:out value="${debate.data}" />" placeholder="data" type="text"/>
				<br />
				<input type="hidden" name="comando" value="RegisterDebates" /> 
				<input type="hidden" name="nome" value="${debate.nome} }" /> 
				<input type="button"  value="Cadastrar debate" class="rc-button rc-button-submit" />
			</form>
		</div>

	</div>
</body>
</html>