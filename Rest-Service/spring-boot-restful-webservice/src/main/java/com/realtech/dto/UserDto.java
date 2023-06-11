package com.realtech.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "User DTO Model Information")
public class UserDto {

	private Long id;
	@Schema(description = "User First Name")
	@NotEmpty(message = "User First name should not be null or empty")
	private String firstName;
	@Schema(description = "User Last Name")
	@NotEmpty(message = "User Last name should not be null or empty")
	private String lastName;
	@Schema(description = "User Email Address")
	@NotEmpty(message = "User Email name should not be null or empty")
	@Email(message = "Email addres should be valid")
	private String email;

	public UserDto() {
	};

	public UserDto(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
