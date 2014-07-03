$(function() {	
//	ShowDebates();
	$("input[name='debate-view']").click(DebateView);
});

function DebateView(){
	var debate = $(this).attr('title');
	
	$.ajax({
		type: "GET",
		url : "ServletDE",
		data : "comando=ShowDebate&nome="+debate,
		dataType : "json",
		async : false,
		complete : function(response){
			console.log(response.responseText);
			if(response.responseText){
				console.log("asdad");
				window.location.href = "debate-eleitoral.jsp";
			}
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