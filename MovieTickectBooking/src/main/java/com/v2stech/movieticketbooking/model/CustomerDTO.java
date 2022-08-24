package com.v2stech.movieticketbooking.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class CustomerDTO {

	private int customerId;
	@NotEmpty(message = "Email Can not be empty")
	@Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Email Should be in proper format")
	private String email;
	@NotEmpty(message = "Phone Can not be empty")
	@Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Phone must numerice only")
	@Size(min = 10 , message = "Phone must 10 digit")
	private String phone;
	@NotEmpty(message = "First Name Can not be empty")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Only Alphabets")
	@Size(min = 2, max = 11)
	@JsonProperty(value = "firstname")
	private String firstName;
	@NotEmpty(message = "Last Name Can not be empty")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Only Alphabets")
	@Size(min = 2, max = 11)
	@JsonProperty(value = "lastname")
	private String lastName;
	@NotEmpty(message = "Birth Can not be empty")
	private String birth;
	private String gender;
	@NotEmpty(message = "Address Can not be empty")
	private String addressLine1;
	@NotEmpty(message = "Address Can not be empty")
	private String addressLine2;
	@NotEmpty(message = "AreaPincode Can not be empty")
	@Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "Pincode must numerice only")
	@Size(min = 6,max = 8)
	private String areaPincode;
	private String cityId;
	@NotEmpty(message = "User Name Can not be empty")
	@Size(min = 2, max = 11)
	@JsonProperty(value = "username")
	private String userName;
	@NotEmpty(message = "Password Can not be empty")
	private String password;
	@NotEmpty(message = "Select City Name")
	@JsonProperty(value = "cityname")
	private String cityName;

}
