package com.v2stech.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreType
public class CustomerDTO {

	@JsonProperty(value = "customerId")
	private int customer_id;
	private String email;
	private String phone;
	@JsonProperty(value = "firstName")
	private String first_name;
	@JsonProperty(value = "lastName")
	private String last_name;
	private String birth;
	private String gender;
	private String addressLine1;
	private String addressLine2;
	private String areaPincode;
	@JsonProperty(value = "cityId")
	private String city_id;
	@JsonProperty(value = "userName")
	private String user_name;
	private String password;
	@JsonProperty(value = "cityName")
	private String city_name;

}
