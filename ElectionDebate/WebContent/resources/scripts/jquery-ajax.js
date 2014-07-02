$(function() {
	
	
	ShowDebates();
	alert('saadasdd');
});



function ShowDebates(){
	
//	$("#lista-debates").load("ServletDAR?comando=ShowDebates");
	$.ajax({
		url : "ServletDAR",
		data : "comando=ShowDebates",
		dataType : "json",
		success : showDebates
	});
}

function showDebates(debates){
	alert('asdas');
}