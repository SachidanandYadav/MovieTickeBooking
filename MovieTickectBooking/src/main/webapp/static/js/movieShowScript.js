$(document).ready(function(){
	
	getMovieShowData();
	
});

	function getMovieShowData() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/movieShowList",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].show_id + "</td><td>" + response[res].show_date + "</td><td>" + response[res].startTime + "</td><td>" + response[res].endTime + "</td><td>" + response[res].hall_name + "</td><td>" + response[res].title + "</td><td><button type='button' class='btn btn-info mr-2' onclick='editData(" + response[res].show_id + ")' data-toggle='modal'  data-target='#exampleModal' style='margin-right: 5px;'><i class='fa fa-edit'></i></button><button type='button' data-toggle='modal'  data-target='#confirm-delete' class='btn btn-danger' id='deleteData' onclick='deleteData(" + response[res].show_id + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
				}
			},
			failure: function(response) {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function(response) {
				$('#error').show();
				$("#error").delay(8000).fadeOut("slow");
			}
		});
	}
	
		
	
	function selectCityOption(){
		var id = $('#cityid').val();
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/cinemaHallList/" + id,
			type: "GET",
			success: function(response, status) {
				$("#hallname").html("");
				$("#hallname").append("<option selected disabled>Choose Option</option>")
				for (res in response) {
					$("#hallname").append("<option value=" + response[res].hall_name + ">" + response[res].hall_name + "</option>")
				}
			},
			failure: function(response) {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function(response) {
				$('#error').show();
				$("#error").delay(8000).fadeOut("slow");
			}
		});
	}
	
$("#MovieShow").on("click", function() {
	var movie = {}
	movie.show_id = $('#showid').val();
	movie.show_date = $('#showdata').val();
	movie.startTime = $('#startTime').val();
	movie.endTime = $('#endTime').val();
	movie.hall_name = $('#hallname').val();
	movie.title = $('#movie').val();
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/MovieShow",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(movie),
		success: function(response) {
			$("#user-table").html("");
			getMovieShowData();
			$('#addSuccess').show();
			$("#addSuccess").delay(8000).fadeOut("slow");
		},
		failure: function(response) {
			$('#failure').show();
			$("#failure").delay(8000).fadeOut("slow");
		},
		error: function(response) {
			$('#error').show();
			$("#error").delay(8000).fadeOut("slow");
		}
	});
});


	
function editData(id) {	
	$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/movieShow/" + id,
			type: "GET",
			success: function(res) {
				$('#showid').val(res[0].show_id);
				$('#showdata').val(res[0].show_date);
				$('#startTime').val(res[0].startTime);
				$('#endTime').val(res[0].endTime);
				$("#hallname").append("<option selected value=" + res[0].hall_name + ">" + res[0].hall_name + "</option>")
				$("#movie").append("<option selected value=" + res[0].title + ">" + res[0].title + "</option>")
			},
			failure: function(res) {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function(res) {
				$('#error').show();
				$("#error").delay(8000).fadeOut("slow");
			}
		});
}


function deleteData(id) {
	$("#delete").on("click", function() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/DeleteMovieShow/" + id,
			type: "DELETE",
			success: function(response, status) {
				$("#user-table").html("");
				getMovieShowData();
				$('#deleteSuccess').show();
				$("#deleteSuccess").delay(8000).fadeOut("slow");
			},
			failure: function(response) {
				$('#failure').show();
				$("#failure").delay(8000).fadeOut("slow");
			},
			error: function(response) {
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
	