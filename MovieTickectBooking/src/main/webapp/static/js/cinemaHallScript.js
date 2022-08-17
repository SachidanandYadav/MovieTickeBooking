$(document).ready(function(){
	
	getCinemaHallData();
	
});

	function getCinemaHallData() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/cinemaHallList",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].hall_id + "</td><td>" + response[res].hall_name + "</td><td>" + response[res].total_seat + "</td><td>" + response[res].address + "</td><td>" + response[res].city_name + "</td><td>" + response[res].state_name + "</td><td><button type='button' class='btn btn-info mr-2' onclick='editData(" + response[res].hall_id + ")' data-toggle='modal'  data-target='#exampleModal' style='margin-right: 5px;'><i class='fa fa-edit'></i></button><button type='button' data-toggle='modal'  data-target='#confirm-delete' class='btn btn-danger' id='deleteData' onclick='deleteData(" + response[res].hall_id + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
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
	
	
	
	function editData(id) {
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/cinemaHall/" + id,
		type: "GET",
		success: function(res) {
			$('#hallid').val(res[0].hall_id);
			$('#hallName').val(res[0].hall_name);
			$('#totalSeat').val(res[0].total_seat);
			$('#address').val(res[0].address);
			$("#city").html("");
			$("#city").append("<option value=" + res[0].city_name + ">" + res[0].city_name + "</option>")
			
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


	
	function selectOption(){
		var id = $('#stateid').val();
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/cinemaStateList/" + id,
			type: "GET",
			success: function(response, status) {
				$("#city").html("");
				for (res in response) {
					$("#city").append("<option value=" + response[res].city_name + ">" + response[res].city_name + "</option>")
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
	
	
	$("#CinemaHall").on("click", function() {
	var hall = {}
	hall.hall_id = $('#hallid').val();
	hall.hall_name = $('#hallName').val();
	hall.total_seat = $('#totalSeat').val();
	hall.address = $('#address').val();
	hall.city_name = $('#city').val();
	hall.state_id = $('#stateid').val();
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/CinemaHall",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(hall),
		success: function(response) {
			$("#user-table").html("");
			getCinemaHallData();
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
	
	
function deleteData(id) {
	$("#delete").on("click", function() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/DeleteCinemaHall/" + id,
			type: "DELETE",
			success: function(response, status) {
				$("#user-table").html("");
				getCinemaHallData();
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
	

	
	function resetAllFiled() {
	$('#hallid').val('');	
	$('#hallName').val('');
	$('#totalSeat').val('');
	$('#address').val('');
	$('#city').val('');
	$('#stateid').val('');
	
}
	

	