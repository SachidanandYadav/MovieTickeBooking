package com.v2stech.movieticketbooking.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Data;

@Data
@JsonIgnoreType
public class CustomerDTO {

	private int customer_id;
	@NotEmpty(message = "Email Can not be empty")
	@Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Email Should be in proper format")
	private String email;
	@NotEmpty(message = "Phone Can not be empty")
	@Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Phone must numerice only")
	@Size(min = 10, message = "Phone must 10 digit")
	private String phone;
	@NotEmpty(message = "First Name Can not be empty")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Only Alphabets")
	@Size(min = 2, max = 11)
	private String first_name;
	@NotEmpty(message = "Last Name Can not be empty")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Only Alphabets")
	@Size(min = 2, max = 11)
	private String last_name;
	@NotEmpty(message = "Birth Can not be empty")
	private String birth;
	private String gender;
	@NotEmpty(message = "Address Can not be empty")
	private String addressLine1;
	@NotEmpty(message = "Address Can not be empty")
	private String addressLine2;
	@NotEmpty(message = "AreaPincode Can not be empty")
	@Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Pincode must numerice only")
	@Size(min = 6, max = 8)
	private String areaPincode;
	private String city_id;
	@NotEmpty(message = "User Name Can not be empty")
	@Size(min = 2, max = 11)
	private String user_name;
	@NotEmpty(message = "Password Can not be empty")
	private String password;
	@NotEmpty(message = "Select City Name")
	private String city_name;

}
