$(document).ready(function(){
	
	getMovieShowData();
	
});

	function getMovieShowData() {
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/movie-show-list",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].showId + "</td><td>" + response[res].showDate + "</td><td>" + response[res].startTime + "</td><td>" + response[res].endTime + "</td><td>" + response[res].hallName + "</td><td>" + response[res].title + "</td><td><button type='button' class='btn btn-info mr-2' onclick='editData(" + response[res].showId + ")' data-toggle='modal'  data-target='#exampleModal' style='margin-right: 5px;'><i class='fa fa-edit'></i></button><button type='button' data-toggle='modal'  data-target='#confirm-delete' class='btn btn-danger' id='deleteData' onclick='deleteData(" + response[res].showId + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
				}
			},
			failure: function() {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function() {
				$('#error').show();
				$("#error").delay(8000).fadeOut("slow");
			}
		});
	}
	
		
	
	function selectCityOption(){
		var id = $('#cityid').val();
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/cinema-hall-list/" + id,
			type: "GET",
			success: function(response) {
				$("#hallname").html("");
				$("#hallname").append("<option selected disabled>Choose Option</option>")
				for (res in response) {
					$("#hallname").append("<option value=" + response[res].hallName + ">" + response[res].hallName + "</option>")
				}
			},
			failure: function() {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function() {
				$('#error').show();
				$("#error").delay(8000).fadeOut("slow");
			}
		});
	}
	
	
	function check(filed, message) {
	if (filed == "" || filed == null) {
		$("#" + message + "Error").html(message + " Filed is Required");
		$("#" + message + "Error").show();
		flag = false;
	} else {
		$("#" + message + "Error").hide();
		flag = true;
	}
	return flag;
}
	
$("#MovieShow").on("click", function() {
	var movie = {}
	movie.showId = $('#showid').val();
	movie.showDate = $('#showdate').val();
	movie.startTime = $('#startTime').val();
	movie.endTime = $('#endTime').val();
	movie.hallName = $('#hallname').val();
	movie.title = $('#movie').val();
	
	var cityId = $('#cityid').val();
	
	var showDate = check(movie.showDate, "Showdate");
	var startTime = check(movie.startTime , "StartTime");
	var endTime = check(movie.endTime, "EndTime");
	var cityid = check(cityId, "City");
	var hallName = check(movie.hallName, "Hallname");
	var title = check(movie.title, "Movie");
	
	
	if (showDate && startTime && endTime && hallName && title && cityid ) {
	restAllError();
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/movie-show",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(movie),
		success: function() {
			$('.close').click();
			$("#user-table").html("");
			getMovieShowData();
			$('#addSuccess').show();
			$("#addSuccess").delay(8000).fadeOut("slow");
		},
		failure: function() {
			$('#failure').show();
			$("#failure").delay(8000).fadeOut("slow");
		},
		error: function(message) {
			$('#ShowdateError').html(message.responseJSON.showDate);
			$('#ShowdateError').show();
			$('#StartTimeError').html(message.responseJSON.startTime);
			$('#StartTimeError').show();
			$('#EndTimeError').html(message.responseJSON.endTime);
			$('#EndTimeError').show();
			$('#CityError').html(message.responseJSON.cityName);
			$('#CityError').show();
			$('#HallnameError').html(message.responseJSON.hallName);
			$('#HallnameError').show();
			$('#MovieError').html(message.responseJSON.title);
			$('#MovieError').show();
		}
	});
	}
});


	
function editData(id) {	
	$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/movie-show/" + id,
			type: "GET",
			success: function(res) {
				$('#showid').val(res.showId);
				$('#showdate').val(res.showDate);
				$('#startTime').val(res.startTime);
				$('#endTime').val(res.endTime);
				$("#cityid").append("<option selected disabled value=" + res.cityName + ">" + res.cityName + "</option>")
				$("#hallname").append("<option selected value=" + res.hallName + ">" + res.hallName + "</option>")
				$("#movie").append("<option selected value=" + res.title + ">" + res.title + "</option>")
			},
			failure: function() {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function() {
				$('#error').show();
				$("#error").delay(8000).fadeOut("slow");
			}
		});
}


function deleteData(id) {
	$("#delete").on("click", function() {
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/delete-movie-show/" + id,
			type: "DELETE",
			success: function() {
				$("#user-table").html("");
				getMovieShowData();
				$('#deleteSuccess').show();
				$("#deleteSuccess").delay(8000).fadeOut("slow");
			},
			failure: function() {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function() {
				$('#error').show();
				$("#error").delay(8000).fadeOut("slow");
			}
		});
	});
}

function reload() {
	location.reload(true);	
}

function resetAllFiled() {
	$('#showid').val('');
	$('#showdate').val('');
	$('#startTime').val('');
	$('#endTime').val('');
	$('#cityid').val('');
	$('#hallname').val('');
	$('#movie').val('');
	
}


function restAllError() {
	$('#ShowdateError').html("");
	$('#StartTimeError').html("");
	$('#EndTimeError').html("");
	$('#CityError').html("");
	$('#HallnameError').html("");
	$('#MovieError').html("");
}
	