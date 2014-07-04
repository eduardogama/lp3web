<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				
			</div>
			
			<ul>
				<c:forEach var="candidato" items="candidatos">
				<li>
					${candidato.nome }
				</li>
				</c:forEach>
			</ul>
			
			<form action="ServletDE" method="post" name="formCandidatos">
				<fieldset>
					<label for="nome">Nome:</label>
					<input name="nome" id="nome" placeholder="nome" type="text"/>			
					<br />
					<label for="descricao" >Partido:</label>
					<input name="partido" id="partido" placeholder="partido" type="text"/>
					<br />
					<label for="data" >Idade:</label>
					<input name="idade" id="idade" placeholder="idade" type="text"/>
					<br />
					
					<input type="hidden" name="comando" value="RegisterCandidato" /> 
					<input type="hidden" name="title" value="${debate.nome}" /> 
					
					<input type="submit" value="Cadastrar cadidato" class="rc-button rc-button-submit" />
				</fieldset>
			</form>
			
			<form action="ServletDAR" method="post" name="formPerguntas">
				<a href="CadastrarPergunta.jsp" >
					<input type="button"  value="Cadastrar pergunta" class="rc-button rc-button-submit" />
				</a>
			</form>
			
		</div>
	</div>

</body>
</html>