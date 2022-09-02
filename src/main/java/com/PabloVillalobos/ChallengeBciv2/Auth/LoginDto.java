package com.PabloVillalobos.ChallengeBciv2.Auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class LoginDto {
	
	private String name;
	
	@Email
	private String email;
	
	@NotNull
	@NotEmpty
	@Length(min = 8, max = 12)
	@Pattern(regexp = "^(?:\\D*\\d){2}\\D*$", message = "Password no Cumple - debe de contener 2 digitos")
	@Pattern(regexp = "^[^A-Z]*[A-Z][^A-Z]*$", message = "Password no cumple - debe de contener 1 Mayuscula")
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
