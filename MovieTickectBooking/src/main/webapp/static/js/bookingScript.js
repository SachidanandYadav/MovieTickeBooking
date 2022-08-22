$(document).ready(function(){
	
	getBookingData();
	
});

	function getBookingData() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/booking-list",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].bookingId + "</td><td>" + response[res].seat + "</td><td>" + response[res].bookingTime + "</td><td>" + response[res].userName + "</td><td>" + response[res].showDate + "</td><td><button type='button' data-toggle='modal'  data-target='#confirm-delete' class='btn btn-danger' id='deleteData' onclick='deleteData(" + response[res].bookingId + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
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
	

function deleteData(id) {
	$("#delete").on("click", function() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/delete-booking/" + id,
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
	