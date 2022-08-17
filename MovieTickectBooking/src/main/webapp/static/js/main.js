    $(document).ready(function () {
        
    });

$("#addCustomer").on("click", function() {
	var customer = {}
	customer.first_name = $('#first_name').val();
	customer.last_name = $('#last_name').val();
	customer.email = $('#email').val();
	customer.phone = $('#phone').val();
	customer.birth = $('#birth').val();
	customer.gender = $('#gender').val();
	customer.addressLine1 = $('#addressLine1').val();
	customer.addressLine2 = $('#addressLine2').val();
	customer.city_id = $('#city').val();
	customer.areaPincode = $('#areaPincode').val();
	customer.user_name = $('#username').val();
	customer.password = $('#password').val();
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/customer",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(customer),
		success: function(response) {
			$('#addSuccess').show();
			resetAllFiled();
			$("#addSuccess").delay(8000).fadeOut("slow");
		},
		error: function(response) {
			$('#error').show();
			$("#error").delay(8000).fadeOut("slow");
		}
	});
});

	
$("#login").on("click", function() {
	var login = {}
	login.isAdmin = $('#adminlogin').val();
	login.user_name = $('#username').val();
	login.password = $('#password').val();
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/LoginCustomer",
		type: "POST",
		contentType: 'application/json',
		data: JSON.stringify(login),
		success: function(response) {
			window.location.href = "/MovieTickectBooking/"+response;
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
    if(checkbox.checked == true){
       $('#adminlogin').val("1");
    }else{
         $('#adminlogin').val("0");
   }
}


function myFunction(movieName) {
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/MovieTickectBooking/movieDetails/" + movieName,
		cache: false,
		success: function(response) {
			window.location.href = "/MovieTickectBooking/"+response;
			console.log(response)
		},
		error: function(response) {
			$('#error').show();
			resetAllFiled();
			$("#error").delay(8000).fadeOut("slow");
		}
	});
}

function selectCityOption(){
		var id = $('#cityid').val();
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/cinemaHallList/" + id,
			type: "GET",
			success: function(response, status) {
				$('#table-div').show();
				$("#user-table").html("");
				for (res in response) {
					$("#user-table").append("<tr><td><input type='hidden'  id='hallid' value="+ response[res].hall_id + ">" + response[res].hall_name + "</td><td>" + response[res].address + "</td><td><button type='button' class='btn btn-danger mr-2' onclick='movieShow(" + response[res].hall_id + ")' data-toggle='modal'  data-target='#exampleModal' style='margin-right: 5px;'>All Show</i></button></td></tr>")
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
	
	

function movieShow(id) {
	var title = $('#movieTitle').val();
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/MovieShowDetail/" + id +"/"+ title,
		type: "GET",
		success: function(response) {
			window.location.href = "/MovieTickectBooking/"+response;
			console.log("Hello World");
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


function  totalSeat(){
	var seatTypeId = $('#seatType').val();
	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/TotalSeat/"+ seatTypeId,
		type: "GET",
		success: function(response) {
			$('#totalSeat').val(response[0].seat);
			$('#seatPrice').val(response[0].price)
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
	
	
	function totalPrice(){
		var totalSeat = $('#seat').val();
		var seatPrice = $('#seatPrice').val();
		var totalAmount = (totalSeat * seatPrice);
		$('#totalAmount').val(totalAmount);
	
	}
	
	
	function payment(){
	var finalPrice = $('#totalAmount').val();	
	$("#pay").on("click", function() {
		var booking = {}
		booking.user_name = $('#userName').val();
		booking.seat = $('#seat').val();
		booking.amount = $('#finalAmount').val();
		booking.methodId = $('#paymentMentod').val();
		$.ajax({
			url: "http://localhost:8080/MovieTickectBooking/BookingDetail",
			type: "POST",
			contentType: 'application/json',
			data: JSON.stringify(booking),
			success: function(response) {
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

	$.ajax({
		url: "http://localhost:8080/MovieTickectBooking/PaymentMethod",
		type: "GET",
		success: function(response) {
			$('#finalAmount').val(finalPrice);
			$("#paymentMentod").html("");
			$("#paymentMentod").append("<option selected disabled>Choose Option</option>")
			for (res in response) {
				$("#paymentMentod").append("<option value=" + response[res].methodId + ">" + response[res].methodType + "</option>")
			}
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





		
	
