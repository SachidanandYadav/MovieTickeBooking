$(document).ready(function() {

});


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

function alphaPattern(field, message) {
	var alphaRegex = new RegExp('^[a-zA-Z]+$');
	if (!alphaRegex.test(field)) {
		$("#" + message + "Error").html(message + " Filed is Required Only Alphabets");
		$("#" + message + "Error").show();
		flag = false;
	} else {
		$("#" + message + "Error").hide();
		flag = true;
	}
	return flag;
}


function NumberPattern(field, message) {
	var NumberRegex = new RegExp('^[0-9]*$');
	if (!NumberRegex.test(field)) {
		$("#" + message + "Error").html(message + " Filed is Required Only Numeric");
		$("#" + message + "Error").show();
		flag = false;
	} else {
		$("#" + message + "Error").hide();
		flag = true;
	}
	return flag;
}

function emailPattern(field) {
	var EmailRegex = new RegExp('^[a-z]+[a-z0-9.+]+@[A-Za-z]+[.]{1}[A-Za-z]{2,}$');
	if (!EmailRegex.test(field)) {
		$("#EmailError").html("Email Formate is not matching");
		$("#EmailError").show();
		flag = false;
	} else {
		$("#EmailError").hide();
		flag = true;
	}
	return flag;
}


function phonelength(field) {
	if (field.length < 10) {
		$("#PhoneError").html("Phone Number should be of minimum 10 digits");
		$("#PhoneError").show();
		flag = false;
	} else {
		$("#PhoneError").hide();
		flag = true;
	}
	return flag;
}

function pincodelength(field) {
	if (field.length != 6) {
		$("#AreaPincodeError").html("AreaPincode should be 6 digits");
		$("#AreaPincodeError").show();
		flag = false;
	} else {
		$("#AreaPincodeError").hide();
		flag = true;
	}
	return flag;
}



$("#addCustomer").on("click", function() {
	var customer = {}
	customer.firstname = $('#first_name').val();
	customer.lastname = $('#last_name').val();
	customer.email = $('#email').val();
	customer.phone = $('#phone').val();
	customer.birth = $('#birth').val();
	customer.gender = $('#gender').val();
	customer.addressLine1 = $('#addressLine1').val();
	customer.addressLine2 = $('#addressLine2').val();
	customer.cityname = $('#city').val();
	customer.areaPincode = $('#areaPincode').val();
	customer.username = $('#username').val();
	customer.password = $('#password').val();

	var firstname = check(customer.firstname, "Firstname");
	var lastname = check(customer.lastname, "Lastname");
	var email = check(customer.email, "Email");
	var phone = check(customer.phone, "Phone");
	var birth = check(customer.birth, "Birth");
	var addressLine1 = check(customer.addressLine1, "Address");
	var addressLine2 = check(customer.addressLine2, "Address2");
	var cityName = check(customer.cityname, "City");
	var areaPincode = check(customer.areaPincode, "AreaPincode");
	var username = check(customer.username, "Username");
	var password = check(customer.password, "Password");


	if (firstname && lastname) {
		var firstnamePattern = alphaPattern(customer.firstname, "Firstname");
		var lastnamePattern = alphaPattern(customer.lastname, "Lastname");
	}

	if (phone && password && areaPincode) {
		var phonePattern = NumberPattern(customer.phone, "Phone");
		var passwordPattern = NumberPattern(customer.password, "Password");
		var areaPincodePattren = NumberPattern(customer.areaPincode, "AreaPincode");
	}

	var EmailPattern = emailPattern(customer.email);

	if (phonePattern) {
		var Phonelength = phonelength(customer.phone);
	}

	if (areaPincodePattren) {
		var Pincodelength = pincodelength(customer.areaPincode);
	}

	if (firstname && lastname && email && phone && birth && addressLine1 && addressLine2 && cityName && areaPincode && username && password && firstnamePattern && lastnamePattern && phonePattern && passwordPattern && areaPincodePattren && EmailPattern && Phonelength && Pincodelength) {
		restAllError();
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/customer",
			type: "POST",
			contentType: 'application/json',
			data: JSON.stringify(customer),
			success: function() {
				$('#addSuccess').show();
				resetAllFiled();
				$("#addSuccess").delay(8000).fadeOut("slow");
			},
			error: function(message) {
				$('#FirstnameError').html(message.responseJSON.firstName);
				$('#FirstnameError').show();
				$('#LastnameError').html(message.responseJSON.lastName);
				$('#LastnameError').show();
				$('#EmailError').html(message.responseJSON.email);
				$('#EmailError').show();
				$('#PhoneError').html(message.responseJSON.phone);
				$('#PhoneError').show();
				$('#BirthError').html(message.responseJSON.birth);
				$('#BirthError').show();
				$('#AddressError').html(message.responseJSON.addressLine1);
				$('#AddressError').show();
				$('#Address2Error').html(message.responseJSON.addressLine1);
				$('#Address2Error').show();
				$('#CityError').html(message.responseJSON.cityName);
				$('#CityError').show();
				$('#AreaPincodeError').html(message.responseJSON.areaPincode);
				$('#AreaPincodeError').show();
				$('#UsernameError').html(message.responseJSON.userName);
				$('#UsernameError').show();
				$('#PasswordError').html(message.responseJSON.password);
				$('#PasswordError').show();

			}
		});
	}
});


$("#login").on("click", function() {
	
	$.ajax({
		url: "http://127.0.0.1:8080/MovieTickectBooking/session-destroy",
		type: "GET",
		success: function() {
			console.log("Success");
		},
		error: function() {
			console.log("Success");
		}
	});
	
	

	var login = {}
	login.isAdmin = $('#adminlogin').val();
	login.username = $('#username').val();
	login.password = $('#password').val();


	var Username = check(login.username, "Username");
	var Password = check(login.password, "Password");


	if (Username && Password) {
		$('#userNameError').html("");
		$('#passwordError').html("");
		$.ajax({
			url: "http://127.0.0.1:8080/MovieTickectBooking/login-customer",
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
				$('#UsernameError').html(message.responseJSON.username);
				$('#PasswordError').html(message.responseJSON.password);
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
	$('#username').val('');
	$('#password').val('');
}

function restAllError() {
	$('#FirstnameError').html("");
	$('#LastnameError').html("");
	$('#EmailError').html("");
	$('#PhoneError').html("");
	$('#BirthError').html("");
	$('#AddressError').html("");
	$('#Address2Error').html("");
	$('#CityError').html("");
	$('#AreaPincodeError').html("");
	$('#UsernameError').html("");
	$('#PasswordError').html("");
}

function handleChange(checkbox) {
	if (checkbox.checked == true) {
		$('#adminlogin').val("1");
	} else {
		$('#adminlogin').val("0");
	}
}
