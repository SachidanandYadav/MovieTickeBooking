$(document).ready(function(){
	
	getBookingData();
	
});

	function getBookingData() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/bookingList",
			type: "GET",
			success: function(response) {
				for (res in response) {
					$("#user-table").append("<tr><td>" + response[res].booking_id + "</td><td>" + response[res].seat + "</td><td>" + response[res].booking_time + "</td><td>" + response[res].user_name + "</td><td>" + response[res].show_date + "</td><td><button type='button' data-toggle='modal'  data-target='#confirm-delete' class='btn btn-danger' id='deleteData' onclick='deleteData(" + response[res].booking_id + ")' ><i class='far fa-trash-alt'></i></button></td></tr>")
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
	

function deleteData(id) {
	$("#delete").on("click", function() {
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/DeleteBooking/" + id,
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
	