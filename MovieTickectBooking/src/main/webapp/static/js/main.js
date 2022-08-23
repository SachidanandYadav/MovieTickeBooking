$(document).ready(function() {
	/* getBookingHistory();*/
});

$("#addCustomer").on("click", function() {
	var customer = {}
	customer.firstName = $('#first_name').val();
	customer.lastName = $('#last_name').val();
	customer.email = $('#email').val();
	customer.phone = $('#phone').val();
	customer.birth = $('#birth').val();
	customer.gender = $('#gender').val();
	customer.addressLine1 = $('#addressLine1').val();
	customer.addressLine2 = $('#addressLine2').val();
	customer.cityId = $('#city').val();
	customer.areaPincode = $('#areaPincode').val();
	customer.userName = $('#username').val();
	customer.password = $('#password').val();
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/customer",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(customer),
		success: function() {
			$('#addSuccess').show();
			resetAllFiled();
			$("#addSuccess").delay(8000).fadeOut("slow");
		},
		error: function() {
			$('#error').show();
			$("#error").delay(8000).fadeOut("slow");
		}
	});
});

function check(filed, message) {
	if (filed == "" || filed == null) {
		$("#" + message + "Error").html(message + " is Required");
		$("#" + message + "Error").show();
		flag = false;
	} else {
		$("#" + message + "Error").hide();
		flag = true;
	}
	return flag;
}


$("#login").on("click", function() {

	var login = {}
	login.isAdmin = $('#adminlogin').val();
	login.username = $('#username').val();
	login.password = $('#password').val();


	var Username = check(login.username, "username");
	var Password = check(login.password, "password");


	if (Username && Password) {
		$('#userNameError').html("");
		$('#passwordError').html("");
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/login-customer",
			type: "POST",
			contentType: 'application/json',
			data: JSON.stringify(login),
			success: function(response) {
				window.location.href = "/MovieTickectBooking/" + response;
			},
			error: function(message) {
				$('#error1').html(message.responseText)
				$('#error').show();
				$("#error").delay(8000).fadeOut("slow");
				$('#usernameError').html(message.responseJSON.userName);
				$('#passwordError').html(message.responseJSON.password);
			}
		});
	}
});


function resetAllFiled() {
	$('#first_name').val('');
	$('#last_name').val('');
	$('#email').val('');
	$('#phone').val('');
	$('#birth').val('');
	$('#addressLine1').val('');
	$('#addressLine2').val('');
	$('#city').val('');
	$('#areaPincode').val('');
	$('#user_name').val('');
	$('#password').val('');
}

function handleChange(checkbox) {
	if (checkbox.checked == true) {
		$('#adminlogin').val("1");
	} else {
		$('#adminlogin').val("0");
	}
}


function myFunction(movieName) {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/MovieTickectBooking/movie-details/" + movieName,
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
		url: "http://localhost:8080/MovieTickectBooking/cinema-hall-list/" + id,
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
		url: "http://localhost:8080/MovieTickectBooking/movie-show-detail/" + id + "/" + title,
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
		url: "http://localhost:8080/MovieTickectBooking/total-seat/" + seatTypeId,
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
			url: "http://localhost:8080/MovieTickectBooking/booking-detail",
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
		url: "http://localhost:8080/MovieTickectBooking/payment-method",
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
		url: "http://localhost:8080/MovieTickectBooking/booking-history-list",
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
		url: "http://localhost:8080/MovieTickectBooking/payment-detail/" + id,
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
		url: "http://localhost:8080/MovieTickectBooking/user-profile",
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
		url: "http://localhost:8080/MovieTickectBooking/update-customer",
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









