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
			<c:forEach var="debate" items="${debates}">
				<ul>
					<li style="padding: 0px 0px 10px 10px; background: #F1F0F5;">
						<h1>${debate.nome}</h1>  
						
						<form action="ServletDE" method="post" name="formDebates">
							<input type="hidden" name="comando" value="ShowDebate" /> 
							<input type="hidden" name="nome" value="${debate.nome}" /> 
							<input type="submit" value="view" class="rc-button" />
						</form>
						
						<form action="ServletDE" method="post" name="formDebates">
							<input type="hidden" name="comando" value="EditDebate" /> 
							<input type="hidden" name="nome" value="${debate.nome}" /> 
							<input type="submit" value="edit" class="rc-button" />
						</form>
								
						<input type="submit" title="${debate.nome}" name="debate-view" value="View" class="rc-button debate-delete" />
						<input type="button" title="${debate.nome}" name="debate-delete" value="Delete" class="rc-button debate-delete" />
						<input type="button" title="${debate.nome}" name="debate-edit" value="Editar" class="rc-button debate-delete" />
						
						
					</li>
				</ul>
			</c:forEach>
			<form action="ServletDAR" method="post" name="formDebates">
				<a href="CadastrarDebate.jsp" >
					<input type="button"  value="Cadastrar debate" class="rc-button rc-button-submit" />
				</a>
			</form>
		</div>

	</div>
</body>
</html>