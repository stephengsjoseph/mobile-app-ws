package com.example.demo.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserRequestModel {
	@NotNull(message="fristName can not be null")
	@Size(min=2, message = "firstName can not be less than 2")
	private String firstName;
	
	@NotNull(message="lastName can not be null")
	@Size(min=2, message = "firstName can not be less than 2")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
