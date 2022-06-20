package com.kodlamaio.rentACar.business.requests.users;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

	@NotBlank(message = "First Name is mandatory")
	@Size(min = 2)
	//@Pattern(regexp = "(^[a-zA-Z]{2,50}$)", message = "Name must be of characters")
	private String name;

	@Size(min = 2)
	//@Pattern(regexp = "(^[a-zA-Z]{2,50}$)", message = "Last Name must be of characters")
	private String lastName;

	@NotBlank(message = "Identity Number is mandatory")
	@Pattern(regexp = "(^[0-9]{11}$)", message = "Identity Number must be 11 characters")
	@Pattern(regexp = "(^\\d*[02468]$)", message = "Identity Number must be of digits and the last character must be an even number")
	private String identityNumber;

	@Email(message = "Email should be valid")
	private String email;

	private String password;
	
	private LocalDate birthDate;

}
