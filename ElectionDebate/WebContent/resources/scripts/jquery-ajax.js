$(function() {
	alert('sad');
	$("#number-button").click(showNum);
	$("#person-button").click(showPersons);
	$("#person-button-2").click(showPersons2);
	$("#retrieve").click(showCustomer);
});

function showCustomer() {
	var idCustomer = "idType=" + $("#id-customer").val();
	$("#load").css("display","block");
	$.ajax({
		url : "ShowCustomer",
		data : idCustomer,
		dataType : "json",
		success : showCustomerScreen
	});
}

function showCustomerScreen(jsonData) {
	
	if (jsonData.firstName != "") {
		var customer = MakeCustomer(jsonData.firstName, jsonData.lastName,
				jsonData.balanceCustomer);
		$("#retrieve-customer").html(customer);
	} else {
		alert("Cliente inexistente");
	}
	$("#load").css("display","none");
}

function MakeCustomer(firstName, lastName, balanceCustomer) {
	return (CustomerStartTags(firstName, lastName, balanceCustomer));
}

function CustomerStartTags(firstName, lastName, balanceCustomer) {
	return ("<ul>" + "<li> Primeiro nome: " + firstName + "</li>"
			+ "<li> Ultimo nome: " + lastName + "</li>" + "<li> Saldo: "
			+ balanceCustomer + "</li>" + "</ul>");
}

function showNum() {
	$("#num-result").load("show-number.jsp");
}
function showList(text, status) {
	$("#person-result").html(text);
}

function showPersons2() {
	var params = {
		param1 : $("#person1").val(),
		param2 : $("#person2").val(),
		param3 : $("#person3").val()
	};
	$("#person-result-serialize").load("show-params.jsp",
			$("#load-form").serialize());
}

function showPersons() {
	var params = {
		param1 : $("#person1").val(),
		param2 : $("#person2").val(),
		param3 : $("#person3").val()
	};
	$.ajax({
		url : "show-params.jsp",
		data : params,
		success : showList
	});
}

function showParams3() {
	$.ajax({
		url : "show-params.jsp",
		data : $("#data-form").serialize(),
		success : showAlert
	});
}

function insertParams() {
	$("#params-result").load("show-params.jsp", $("#load-form").serialize());
}
