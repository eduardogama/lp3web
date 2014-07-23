$(function() {	
	$("input[name='debate-delete']").click(DebateDelete);
	$("input[name='debate-edit']").click(DebateEdit);
	$("input[name='candidato-delete']").click(CandidatoDelete);

});

function DebateEdit(){
	var nome = $("#nome").val();
	var descricao = $("#descricao").val();
	var data = $("#data").val();
	var title = $(this).attr('title');
	
	
	alert(nome + " " + descricao + " " + data);
	var data_send = "comando=EditDebate&nome="+nome+"&descricao="+descricao+"&data="+data+"&title="+title;
	$.post( "ServletDE", data_send, "json");
}

function DebateDelete(){
	var debate = $(this).attr('title');
	
	$.get("ServletDE",{nome : debate, comando : "DeleteDebate"});
	
	$(this).parent('li').hide('slow', function() {
		$(this).remove();
	});
}

function CandidatoDelete(){
	var cddto= $(this).attr('title');
	var dbte = $("title").html();
	
	alert(dbte + " " + cddto);
	
	$.get("ServletDE",{nome : cddto, comando : "DeleteCandidato", title : dbte});
	
	$(this).parent('li').hide('slow', function() {
		$(this).remove();
	});
}

//function DebateView(){
//	var debate = $(this).attr('title');
//	
//	$.ajax({
//		type: "GET",
//		url : "ServletDE",
//		data : "comando=ShowDebates&nome="+debate,
//		dataType : "json",
//		success: function( data, textStatus, jqXHR) {
//			
//			console.log(data.nome);
////			if(response.responseText){
////				console.log("asdad");
////				
////			}
//		}
//	});
//	
//	console.log(debate);
//}


//function ShowDebates(){
//	
////	$("#lista-debates").load("ServletDAR?comando=ShowDebates");
//	$.ajax({
//		url : "ServletDAR",
//		data : "comando=ShowDebates",
//		dataType : "json",
//		success : showDebates
//	});
//}

//function loadDebate(){
//	$.getJSON("ServletDE", {comando : "ShowDebates"})
//		.done( function () {
//			console.log("success");
//		});
//}

function showDebates(debates){
	
}