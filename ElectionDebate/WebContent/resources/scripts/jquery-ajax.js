$(function() {	
//	ShowDebates();
	$("input[name='debate-view']").click(DebateView);
	$("input[name='debate-delete']").click(DebateDelete);
	
//	DebateView();
});


function loadDebate(){
	$.getJSON("ServletDE", {comando : "ShowDebates"})
		.done( function () {
			console.log("success");
		});
}

function DebateDelete(){
	var debate = $(this).attr('title');
	
	$.get("ServletDE",{nome : debate, comando : "DeleteDebate"});
	
	$(this).parent('li').hide('slow', function() {
		$(this).remove();
	});
}

function DebateView(){
	var debate = $(this).attr('title');
	
	$.ajax({
		type: "GET",
		url : "ServletDE",
		data : "comando=ShowDebates&nome="+debate,
		dataType : "json",
		success: function( data, textStatus, jqXHR) {
			
			console.log(data.nome);
//			if(response.responseText){
//				console.log("asdad");
//				
//			}
		}
	});
	
	console.log(debate);
}


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
	
}