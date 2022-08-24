$(document).ready(function(){
	
	getCinemaHallData();
	
});

	function getCinemaHallData() {
		$.ajax({
			url: "http://192.168.20.204:8080/MovieTickectBooking/cinema-hall-list",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].hallId + "</td><td>" + response[res].hallName + "</td><td>" + response[res].totalSeat + "</td><td>" + response[res].address + "</td><td>" + response[res].cityName + "</td><td>" + response[res].stateName + "</td><td><button type='button' class='btn btn-info mr-2' onclick='editData(" + response[res].hallId + ")' data-toggle='modal'  data-target='#exampleModal' style='margin-right: 5px;'><i class='fa fa-edit'></i></button><button type='button' data-toggle='modal'  data-target='#confirm-delete' class='btn btn-danger' id='deleteData' onclick='deleteData(" + response[res].hallId + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
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
	
	
	
	function editData(id) {
	$.ajax({
		url: "http://192.168.20.204:8080/MovieTickectBooking/cinema-hall/" + id,
		type: "GET",
		success: function(res) {
			$('#hallid').val(res.hallId);
			$('#hallName').val(res.hallName);
			$('#totalSeat').val(res.totalSeat);
			$('#address').val(res.address);
			$('#stateName').remove();
			$("#stateid").append("<option selected disabled id='stateName' value=" + res.stateName + ">" + res.stateName + "</option>")
			$("#city").html("");
			$("#city").append("<option value=" + res.cityName + ">" + res.cityName + "</option>")
			
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


	
	function selectOption(){
		var id = $('#stateid').val();
		$.ajax({
			url: "http://192.168.20.204:8080/MovieTickectBooking/cinema-state-list/" + id,
			type: "GET",
			success: function(response) {
				$("#city").html("");
				for (res in response) {
					$("#city").append("<option value=" + response[res].cityName + ">" + response[res].cityName + "</option>")
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
	
	
	$("#CinemaHall").on("click", function() {
	var hall = {}
	hall.hallId = $('#hallid').val();
	hall.hallName = $('#hallName').val();
	hall.totalSeat = $('#totalSeat').val();
	hall.address = $('#address').val();
	hall.cityName = $('#city').val();
	hall.stateId = $('#stateid').val();
	hall.stateName = $('#stateName').val();
	$.ajax({
		url: "http://192.168.20.204:8080/MovieTickectBooking/cinema-halls",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(hall),
		success: function() {
			$("#user-table").html("");
			getCinemaHallData();
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
	
	
function deleteData(id) {
	$("#delete").on("click", function() {
		$.ajax({
			url: "http://192.168.20.204:8080/MovieTickectBooking/delete-cinema-hall/" + id,
			type: "DELETE",
			success: function() {
				$("#user-table").html("");
				getCinemaHallData();
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
	

	
	function resetAllFiled() {
	$('#hallid').val('');	
	$('#hallName').val('');
	$('#totalSeat').val('');
	$('#address').val('');
	$('#city').val('');
	$('#stateid').val('');
	
}
	

	