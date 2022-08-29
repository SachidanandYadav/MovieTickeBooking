$(document).ready(function(){
	
	getCinemaSeatData();
	
});

	function getCinemaSeatData() {
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/cinema-seat-list",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].cinemaSeatId + "</td><td>" + response[res].seat + "</td><td>" + response[res].hallName + "</td><td>" + response[res].seatName + "</td><td><button type='button' class='btn btn-info mr-2' onclick='editData(" + response[res].cinemaSeatId + ")' data-toggle='modal'  data-target='#exampleModal' style='margin-right: 5px;'><i class='fa fa-edit'></i></button><button type='button' data-toggle='modal'  data-target='#confirm-delete' class='btn btn-danger' id='deleteData' onclick='deleteData(" + response[res].cinemaSeatId + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
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
		url: "http://127.0.0.1:8080/MovieTickectBooking/cinema-seat/" + id,
		type: "GET",
		success: function(res) {
			$('#cinemaSeatId').val(res.cinemaSeatId);
			$("#hallName").append("<option value=" + res.hallName + ">" + res.hallName + "</option>")
			$("#seatType").append("<option disabled value=" + res.seatTypeId + ">" + res.seatName + "</option>")
			$('#totalSeat').val(res.seat);
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
		var id = $('#cityid').val();
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/cinema-hall-list/" + id,
			type: "GET",
			success: function(response) {
				$("#hallName").html("");
				for (res in response) {
					$("#hallName").append("<option value=" + response[res].hallName + ">" + response[res].hallName + "</option>")
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


$("#MovieSeat").on("click", function() {
	var seat = {}
	seat.cinemaSeatId = $('#cinemaSeatId').val();
	seat.seat = $('#totalSeat').val();
	seat.hallName = $('#hallName').val();
	seat.seatTypeId = $('#seatType').val();
	seat.cityId = $('#cityid').val();
	
	var cityidValid = check(seat.cityId, "CityId");
	var hallNameValid = check(seat.hallName , "HallName");
	var seatTypeIdValid = check(seat.seatTypeId, "SeatType");
	var seatValid = check(seat.seat, "TotalSeat");
	
	
	if (seatValid && hallNameValid && seatTypeIdValid && cityidValid ) {
	restAllError();
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/cinema-seats",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(seat),
		success: function() {
			$('.close').click();
			$("#user-table").html("");
			getCinemaSeatData();
			$('#addSuccess').show();
			$("#addSuccess").delay(8000).fadeOut("slow");
		},
		failure: function() {
			$('#failure').show();
			$("#failure").delay(8000).fadeOut("slow");
		},
		error: function(message) {
			$('#CityIdError').html(message.responseJSON.city_id);
			$('#CityIdError').show();
			$('#HallNameError').html(message.responseJSON.hallName);
			$('#HallNameError').show();
			$('#SeatTypeError').html(message.responseJSON.seatType_id);
			$('#SeatTypeError').show();
			$('#TotalSeatError').html(message.responseJSON.seat);
			$('#TotalSeatError').show();
			
		}
	});
	}
});

	
function deleteData(id) {
	$("#delete").on("click", function() {
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/delete-cinema-seat/" + id,
			type: "DELETE",
			success: function() {
				$("#user-table").html("");
				location.reload(true);
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
	$('#cinemaSeatId').val('');	
	$('#hallName').val('');
	$('#totalSeat').val('');
	$('#seatType').val('');
	$('#cityid').val('');	
}

function restAllError() {
	$('#CityIdError').html("");
	$('#HallNameError').html("");
	$('#SeatTypeError').html("");
	$('#TotalSeatError').html("");
}