$(document).ready(function(){
	
	getCinemaSeatData();
	
});

	function getCinemaSeatData() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/cinemaSeatList",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].cinemaSeat_id + "</td><td>" + response[res].seat + "</td><td>" + response[res].hall_name + "</td><td>" + response[res].seatName + "</td><td><button type='button' class='btn btn-info mr-2' onclick='editData(" + response[res].cinemaSeat_id + ")' data-toggle='modal'  data-target='#exampleModal' style='margin-right: 5px;'><i class='fa fa-edit'></i></button><button type='button' data-toggle='modal'  data-target='#confirm-delete' class='btn btn-danger' id='deleteData' onclick='deleteData(" + response[res].cinemaSeat_id + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
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
		url: "http://localhost:8080/MovieTickectBooking/cinemaSeat/" + id,
		type: "GET",
		success: function(res) {
			$('#cinemaSeatId').val(res[0].cinemaSeat_id);
			$("#hallName").append("<option value=" + res[0].hall_name + ">" + res[0].hall_name + "</option>")
			$("#seatType").append("<option disabled value=" + res[0].seatType_id + ">" + res[0].seatName + "</option>")
			$('#totalSeat').val(res[0].seat);
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
		var id = $('#cityid').val();
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/cinemaHallList/" + id,
			type: "GET",
			success: function(response, status) {
				$("#hallName").html("");
				for (res in response) {
					$("#hallName").append("<option value=" + response[res].hall_name + ">" + response[res].hall_name + "</option>")
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
	
	function reload() {
	location.reload(true);	
}

function resetAllFiled() {
	$('#cinemaSeatId').val('');	
	$('#hallName').val('');
	$('#totalSeat').val('');
	$('#seatType').val('');
	$('#cityid').val('');
	
}
	
	$("#MovieSeat").on("click", function() {
	var seat = {}
	seat.cinemaSeat_id = $('#cinemaSeatId').val();
	seat.seat = $('#totalSeat').val();
	seat.hall_name = $('#hallName').val();
	seat.seatType_id = $('#seatType').val();
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/CinemaSeat",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(seat),
		success: function(response) {
			$("#user-table").html("");
			getCinemaSeatData();
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
			url: "http://localhost:8080/MovieTickectBooking/DeleteCinemaSeat/" + id,
			type: "DELETE",
			success: function(response, status) {
				$("#user-table").html("");
				location.reload(true);
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
	