var selectedSeats = "";

$(document).ready(function(){
	$('#movieSelect').prop('selectedIndex', -1);
});

$(document).ready(function(){
    $('#movieSelect').on('change' , function() {
        var anchor = $('#showInfoButton');
        anchor.attr('href' , 'showinginfo.jsp?selected_movie=' + $(this).find('option:selected').val());   
    })
});

$(document).ready(function(){
    $('#userinfo').on('click' , function() {
        var anchor = $('#showInfoButton');
        anchor.attr('href' , 'userinfo.jsp?selected_user=' + $('#username').val());   
    })
});

$(document).ready(function(){
    $('#submitLogin').on('click' , function() {
    	var tempUser = $("#submitUser").val();
    	$("#submitUser").value = tempUser.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;') ;
    	var tempPass = $("#submitPass").val();
    	$("#submitPass").value = tempPass.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;') ;
    })
});

$(document).ready(function(){
    $("#hallplan td").click(function(){
    	if($(this).attr('class') != "notavailable" && $(this).attr('class') != "rownumber") {
    		if($(this).attr('class') == "selected") {
    			$(this).attr('class' , ''); 
    		}
    		else {
    			$(this).attr('class' , 'selected');  
    		}
        }
    })
});

$(document).ready(function(){
    $('#reserveButton').on('click' , function() {
        var elems = document.getElementsByTagName('*'), i = 0;
        var anchor = $('#reserve');
        if(!($("#creditcard").val() == "123456")){
    		alert("Please enter valid credit card number.");
    		anchor.attr('href' , "");
    	}
        else {
        
	        for (i in elems) {
	            if(elems[i].className == "selected") {
	            	selectedSeats = selectedSeats + "," + elems[i].id;
	            }
	        }
	        
	        var temp = anchor.attr('href');
	        anchor.attr('href' , temp + '&reserved_seats=' + selectedSeats);  
        }
    })
});
