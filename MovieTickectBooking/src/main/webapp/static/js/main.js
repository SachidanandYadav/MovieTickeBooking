$(document).ready(function() {
});



function myFunction(movieName) {
	$.ajax({
		type: "GET",
		url: "http://127.0.0.1:8080/MovieTickectBooking/movie-details/" + movieName,
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
		url: "http://127.0.0.1:8080/MovieTickectBooking/cinema-hall-list/" + id,
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
		url: "http://127.0.0.1:8080/MovieTickectBooking/movie-show-detail/" + id + "/" + title,
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

function seatValid(filed) {
	if (filed < 0) {
		$("#SeatError").html("Seat Not Available");
		$("#SeatError").show();
		flag = false;
	} else {
		$("#SeatError").hide();
		flag = true;
	}
	return flag;
}


function totalSeat() {
	var seatTypeId = $('#seatType').val();
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/total-seat/" + seatTypeId,
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
	var totalSeat = $('#seat').val();
	var seatTypeId = $('#seatType').val();
	var availableSeat = $('#totalSeat').val();
	var validSeat = (availableSeat - totalSeat);
	
	

	var SeatType = check(seatTypeId, "SeatType");
	var TotalSeat = check(totalSeat, "Seat");
	if(TotalSeat){		
	var seat = seatValid(validSeat);
	}

	if (TotalSeat && SeatType && seat) {
		$("#exampleModal").modal('show');
		$("#PaymentMethodError").html("");
		$("#pay").on("click", function() {
			var booking = {}
			booking.userName = $('#userName').val();
			booking.seat = $('#seat').val();
			booking.amount = $('#finalAmount').val();
			booking.methodId = $('#PaymentMethod').val();
			var PaymentType = check(booking.methodId, "PaymentMethod");
			if (PaymentType) {
				$.ajax({
					url: "http://127.0.0.1:8080/MovieTickectBooking/booking-detail",
					type: "POST",
					contentType: 'application/json',
					data: JSON.stringify(booking),
					success: function() {
						$('.close').click();
						$('#userName').val('');
						$('#seat').val('');
						$('#totalAmount').val('');
						$('#PaymentMethod').val('');
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
					error: function(message) {
						$('#SeatError').html(message.responseText);
						$('#SeatError').show();
					}
				});
			}
		});




		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/payment-method",
			type: "GET",
			success: function(response) {
				$('#finalAmount').val(finalPrice);
				$("#PaymentMethod").html("");
				$("#PaymentMethod").append("<option selected disabled>Choose Option</option>")
				for (res in response) {
					$("#PaymentMethod").append("<option value=" + response[res].methodId + ">" + response[res].methodType + "</option>")
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
}







$("#editCustomer").on("click", function() {
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/user-profile",
		type: "GET",
		success: function(res) {
			$('#customerId').val(res.customer_id);
			$('#firstname').val(res.first_name);
			$('#lastname').val(res.last_name);
			$('#email').val(res.email);
			$('#phone').val(res.phone);
			$('#birth').val(res.birth);
			$('#addressLine1').val(res.addressLine1);
			$('#addressLine2').val(res.addressLine2);
			$('#areaPincode').val(res.areaPincode);
			$('#cityoption').remove();
			$("#city").append("<option selected disabled id='cityoption' value=" + res.city_id + ">" + res.city_name + "</option>");
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
	customer_id = $('#customerId').val();
	var customer = {}
	customer.first_name = $('#firstname').val();
	customer.last_name = $('#lastname').val();
	customer.email = $('#email').val();
	customer.phone = $('#phone').val();
	customer.birth = $('#birth').val();
	customer.addressLine1 = $('#addressLine1').val();
	customer.addressLine2 = $('#addressLine2').val();
	customer.city_id = $('#city').val();
	customer.areaPincode = $('#areaPincode').val();
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/update-customer/"+customer_id,
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