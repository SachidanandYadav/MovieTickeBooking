$(document).ready(function(){
	
	getBookingHistory();
	
});

	function getBookingHistory() {
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/booking-history-list",
		type: "GET",
		success: function(response) {
			for (res in response) {
				$("#booking-table").append("<tr><td>" + response[res].bookingId + "</td><td>" + response[res].seat + "</td><td>" + response[res].bookingTime + "</td><td>" + response[res].startTime + "</td><td><button type='button' class='btn btn-info mr-2' onclick='paymentDetail(" + response[res].bookingId + ")' data-toggle='modal'  data-target='#exampleModal' style='margin-right: 5px;'><i class='fa fa-edit'></i></button></td></tr>")
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


function paymentDetail(id) {
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/payment-detail/" + id,
		type: "GET",
		success: function(res) {
			$('#paymentAmout').val(res.amount);
			$('#paymentMethod').val(res.methodType);
			$('#paymentStatus').val(res.paymentType);
			$('#paymentTime').val(res.paymentTime);

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


function value(id){
	$('#paymentids').val(id);
}
