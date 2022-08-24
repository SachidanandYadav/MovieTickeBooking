$(document).ready(function(){
	
	getMovieShowData();
	
});

	function getMovieShowData() {
		$.ajax({
			url: "http://192.168.20.204:8080/MovieTickectBooking/movie-show-list",
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
			url: "http://192.168.20.204:8080/MovieTickectBooking/cinema-hall-list/" + id,
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
	
$("#MovieShow").on("click", function() {
	var movie = {}
	movie.showId = $('#showid').val();
	movie.showDate = $('#showdata').val();
	movie.startTime = $('#startTime').val();
	movie.endTime = $('#endTime').val();
	movie.hallName = $('#hallname').val();
	movie.title = $('#movie').val();
	$.ajax({
		url: "http://192.168.20.204:8080/MovieTickectBooking/movie-show",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(movie),
		success: function() {
			$("#user-table").html("");
			getMovieShowData();
			$('#addSuccess').show();
			$("#addSuccess").delay(8000).fadeOut("slow");
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


	
function editData(id) {	
	$.ajax({
			url: "http://192.168.20.204:8080/MovieTickectBooking/movie-show/" + id,
			type: "GET",
			success: function(res) {
				$('#showid').val(res.showId);
				$('#showdata').val(res.showDate);
				$('#startTime').val(res.startTime);
				$('#endTime').val(res.endTime);
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
			url: "http://192.168.20.204:8080/MovieTickectBooking/delete-movie-show/" + id,
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
	$('#showdata').val('');
	$('#startTime').val('');
	$('#endTime').val('');
	$('#cityid').val('');
	$('#hallname').val('');
	$('#movie').val('');
	
}
	