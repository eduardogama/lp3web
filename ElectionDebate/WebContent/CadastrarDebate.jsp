<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Debate Eleitoral</title>

	<link rel="stylesheet" type="text/css" href="resources/style/main-style.css" />

</head>
<body class="ui-mobile-viewport">

	<div id="content-page" class="">

		<div id="header">
			<h1>Cadastro Debate</h1>
		</div>

		<div class="card signin-card">
			
			<form action="ServletDE" method="post" name="formDebates">
				<label for="nome">Nome:</label>
				<input name="nome" id="nome" placeholder="nome" type="text"/>			
				<br />
				<label for="descricao" >Descricao:</label>
				<input name="descricao" id="descricao" placeholder="descricao" type="text"/>
				<br />
				<label for="data" >Data:</label>
				<input name="data" id="data" placeholder="data" type="text"/>
				<br />
				<input type="hidden" name="comando" value="RegisterDebate" /> 
				<input type="submit" value="Cadastrar debate" class="rc-button rc-button-submit" />
			</form>

		</div>

	</div>

</body>
</html>