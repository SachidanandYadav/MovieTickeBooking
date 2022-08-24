$(document).ready(function() {
	/* getBookingHistory();*/
});



function myFunction(movieName) {
	$.ajax({
		type: "GET",
		url: "http://192.168.20.204:8080/MovieTickectBooking/movie-details/" + movieName,
		cache: false,
		success: function(response) {
			window.location.href = "/MovieTickectBooking/" + response;
			console.log(response)
		},
		error: function() {
			$('#error').show();
			resetAllFiled();
			$("#error").delay(8000).fadeOut("slow");
		}
	});
}

function selectCityOption() {
	var id = $('#cityid').val();
	$.ajax({
		url: "http://192.168.20.204:8080/MovieTickectBooking/cinema-hall-list/" + id,
		type: "GET",
		success: function(response) {
			$('#table-div').show();
			$("#user-table").html("");
			for (res in response) {
				$("#user-table").append("<tr><td><input type='hidden'  id='hallid' value=" + response[res].hallId + ">" + response[res].hallName + "</td><td>" + response[res].address + "</td><td><button type='button' class='btn btn-danger mr-2' onclick='movieShow(" + response[res].hallId + ")' data-toggle='modal'  data-target='#exampleModal' style='margin-right: 5px;'>All Show</i></button></td></tr>")
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



function movieShow(id) {
	var title = $('#movieTitle').val();
	$.ajax({
		url: "http://192.168.20.204:8080/MovieTickectBooking/movie-show-detail/" + id + "/" + title,
		type: "GET",
		success: function(response) {
			window.location.href = "/MovieTickectBooking/" + response;
			console.log("Hello World");
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


function totalSeat() {
	var seatTypeId = $('#seatType').val();
	$.ajax({
		url: "http://192.168.20.204:8080/MovieTickectBooking/total-seat/" + seatTypeId,
		type: "GET",
		success: function(response) {
			$('#totalSeat').val(response.seat);
			$('#seatPrice').val(response.price)
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


function totalPrice() {
	var totalSeat = $('#seat').val();
	var seatPrice = $('#seatPrice').val();
	var totalAmount = (totalSeat * seatPrice);
	$('#totalAmount').val(totalAmount);

}


function payment() {
	var finalPrice = $('#totalAmount').val();
	$("#pay").on("click", function() {
		var booking = {}
		booking.userName = $('#userName').val();
		booking.seat = $('#seat').val();
		booking.amount = $('#finalAmount').val();
		booking.methodId = $('#paymentMentod').val();
		$.ajax({
			url: "http://192.168.20.204:8080/MovieTickectBooking/booking-detail",
			type: "POST",
			contentType: 'application/json',
			data: JSON.stringify(booking),
			success: function() {
				$('#userName').val('');
				$('#seat').val('');
				$('#totalAmount').val('');
				$('#paymentMentod').val('');
				$('#seatType').val('');
				$('#totalSeat').val('');
				$('#seatPrice').val('');
				$('#finalAmount').val('');

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

	$.ajax({
		url: "http://192.168.20.204:8080/MovieTickectBooking/payment-method",
		type: "GET",
		success: function(response) {
			$('#finalAmount').val(finalPrice);
			$("#paymentMentod").html("");
			$("#paymentMentod").append("<option selected disabled>Choose Option</option>")
			for (res in response) {
				$("#paymentMentod").append("<option value=" + response[res].methodId + ">" + response[res].methodType + "</option>")
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


function getBookingHistory() {
	$.ajax({
		url: "http://192.168.20.204:8080/MovieTickectBooking/booking-history-list",
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
		url: "http://192.168.20.204:8080/MovieTickectBooking/payment-detail/" + id,
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




$("#editCustomer").on("click", function() {
	$.ajax({
		url: "http://192.168.20.204:8080/MovieTickectBooking/user-profile",
		type: "GET",
		success: function(res) {
			$('#customerId').val(res.customerId);
			$('#firstname').val(res.firstName);
			$('#lastname').val(res.lastName);
			$('#email').val(res.email);
			$('#phone').val(res.phone);
			$('#birth').val(res.birth);
			$('#addressLine1').val(res.addressLine1);
			$('#addressLine2').val(res.addressLine2);
			$('#areaPincode').val(res.areaPincode);
			$('#cityoption').remove();
			$("#city").append("<option selected disabled id='cityoption' value=" + res.cityId + ">" + res.cityName + "</option>");
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


function updateCustomer() {
	var customer = {}
	customer.customerId = $('#customerId').val();
	customer.firstName = $('#firstname').val();
	customer.lastName = $('#lastname').val();
	customer.email = $('#email').val();
	customer.phone = $('#phone').val();
	customer.birth = $('#birth').val();
	customer.addressLine1 = $('#addressLine1').val();
	customer.addressLine2 = $('#addressLine2').val();
	customer.cityId = $('#city').val();
	customer.areaPincode = $('#areaPincode').val();
	$.ajax({
		url: "http://192.168.20.204:8080/MovieTickectBooking/update-customer",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(customer),
		success: function() {
			$('#addSuccess').show();
			location.reload(true);
			$("#addSuccess").delay(8000).fadeOut("slow");
		},
		error: function() {
			$('#error').show();
			$("#error").delay(8000).fadeOut("slow");
		}
	});
}









