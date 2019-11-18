package com.example.demo.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequestModel {
	@NotNull(message="fristName can not be null")
	@Size(min=2, message = "firstName can not be less than 2")
	private String firstName;
	
	@NotNull(message="lastName can not be null")
	private String lastName;
	
	@NotNull(message="eMail can not be null")
	@Email(message = "Not an valid email")
	private String eMail;
	
	@NotNull(message="password can not be null")
	@Size(min=8, max=16, message = "Password must be equal to or greater than 8 characters and should be less than 16")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

}
