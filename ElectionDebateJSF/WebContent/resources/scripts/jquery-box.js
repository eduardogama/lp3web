$(document).ready(function() {
	
	$("#rules").click(function(){
		
		if ($('.rules-display').css('display') == 'none'){
			$(".rules-display").show(1000);
		}else {
			$(".rules-display").hide(1000);
		}
	});
//	  $("#rules").click(function(){
//	    $("span").show();
//	  });
	
	
	$('a.login-window').click(function() {
	    
	    //Getting the variable's value from a link 
	    var loginBox = $(this).attr('href');
	
	    //Fade in the Popup
	    $(loginBox).fadeIn(300);
	    
	    //Set the center alignment padding + border see css style
	    var popMargTop = ($(loginBox).height() + 24) / 2; 
	    var popMargLeft = ($(loginBox).width() + 24) / 2; 
	    
	    $(loginBox).css({ 
	        'margin-top' : -popMargTop,
	        'margin-left' : -popMargLeft
	    });
	    
	    // Add the mask to body
	    $('body').append('<div id="mask"></div>');
	    $('#mask').fadeIn(300);
	    
	    return false;
	});
	
	// When clicking on the button close or the mask layer the popup closed
	$('a.close, #mask').live('click', function() { 
	  $('#mask , .box-popup').fadeOut(300 , function() {
	    $('#mask').remove();  
	  }); 
	  return false;
	});
	
$('a.cad-pergunta-window').click(function() {
	    
	    //Getting the variable's value from a link 
	    var loginBox = $(this).attr('href');
	
	    //Fade in the Popup
	    $(loginBox).fadeIn(300);
	    
	    //Set the center alignment padding + border see css style
	    var popMargTop = ($(loginBox).height() + 24) / 2; 
	    var popMargLeft = ($(loginBox).width() + 24) / 2; 
	    
	    $(loginBox).css({ 
	        'margin-top' : -popMargTop,
	        'margin-left' : -popMargLeft
	    });
	    
	    // Add the mask to body
	    $('body').append('<div id="mask"></div>');
	    $('#mask').fadeIn(300);
	    
	    return false;
	});
	
});