$(document).ready(function(){
	
	getShowSeatData();
	
});

	function getShowSeatData() {
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/show-seat-list",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].showSeatId + "</td><td>" + response[res].price + "</td><td>" + response[res].seat+ "</td><td>" + response[res].startTime + " To "+ response[res].endTime +"</td><td>" + response[res].seatName + "</td><td>" + response[res].seatStatusType + "</td><td><button type='button' class='btn btn-info mr-2' onclick='editData(" + response[res].showSeatId + ")' data-toggle='modal'  data-target='#exampleModal' style='margin-right: 5px;'><i class='fa fa-edit'></i></button><button type='button' data-toggle='modal'  data-target='#confirm-delete' class='btn btn-danger' id='deleteData' onclick='deleteData(" + response[res].showSeatId + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
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
	
	
	function selectOption(){
		var id = $('#cityid').val();
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/cinema-hall-list/" + id,
			type: "GET",
			success: function(response) {
				$("#hallName").html("");
				for (res in response) {
					$("#hallName").append("<option value=" + response[res].hallI + ">" + response[res].hallName + "</option>")
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
	
	function selectShowOption(){
		var id = $('#hallName').val();
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/show-seat-details/" + id,
			type: "GET",
			success: function(response) {
				$("#showTime").html("");
				$("#showTime").append("<option selected disabled>Choose Option</option>")
				$("#seatType").html("");
				$("#seatType").append("<option selected disabled>Choose Option</option>")
				for (res in response) {
					$("#showTime").append("<option value=" + response[res].showId + ">" + response[res].startTime +" / "+ response[res].endTime+ "</option>")
					$("#seatType").append("<option value=" + response[res].cinemaSeatId + ">" + response[res].seatName +" - " + response[res].seat +"</option>")
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
	
	
	/*function editData(id) {
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/singleShowSeat/" + id,
		type: "GET",
		success: function(res) {
			$('#showid').val(res[0].showSeat_id);	
			$('#cityid').val('');
			$('#hallName').val('');
			$("#showTime").append("<option value=" + response[res].show_id + ">" + response[res].startTime +" / "+ response[res].endTime+ "</option>")
			$("#seatType").append("<option value=" + response[res].cinemaSeat_id + ">" + response[res].seatName +" - " + response[res].seat +"</option>")
			$('#price').val(res[0].price);
			$("#seatStatus").append("<option value=" + response[res].seatStatus_id + ">" + response[res].seatStatus_Type +"</option>")
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

*/
	
	
	
function reload() {
	location.reload(true);	
}

function resetAllFiled() {
	$('#showid').val('');	
	$('#cityid').val('');
	$('#hallName').val('');
	$('#showTime').val('');
	$('#seatType').val('');
	$('#price').val('');
	$('#seatStatus').val('');
	
}
	
	/*$("#MovieSeat").on("click", function() {
	var seat = {}
	seat.cinemaSeat_id = $('#cinemaSeatId').val();
	seat.seat = $('#totalSeat').val();
	seat.price = $('#price').val();
	seat.seatStatus_id = $('#seatStatus').val();
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/addShowSeat",
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
});*/
	
	
function deleteData(id) {
	$("#delete").on("click", function() {
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/DeleteShowSeat/" + id,
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
