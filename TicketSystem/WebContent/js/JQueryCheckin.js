var selectedMovie;

$(document).ready(function(){
	$('#movieSelect').prop('selectedIndex', -1);
});

$(document).ready(function(){
    $('#movieSelect').on('change' , function() {
        selectedMovie = $(this).find('option:selected').val();  
    })
});

$(document).ready(function(){
    $('#userinfo').on('click' , function() {
        var anchor = $('#showInfoButton');
        anchor.attr('href' , 'checkinuser.jsp?selected_user=' + $('#username').val() + '&selected_movie=' + selectedMovie);  
    })
});

