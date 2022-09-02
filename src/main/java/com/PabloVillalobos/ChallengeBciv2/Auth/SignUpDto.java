package com.PabloVillalobos.ChallengeBciv2.Auth;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.PabloVillalobos.ChallengeBciv2.Phone.PhoneDTO;

public class SignUpDto {
	private String name;
	@Email
	private String email;
	
	@NotNull
	@NotEmpty
	@Length(min = 8, max = 12)
	@Pattern(regexp = "^(?:\\D*\\d){2}\\D*$", message = "Password no Cumple - debe de contener 2 digitos")
	@Pattern(regexp = "^[^A-Z]*[A-Z][^A-Z]*$", message = "Password no cumple - debe de contener 1 Mayuscula")
	private String  password;
	
	private List<PhoneDTO> phones;
	
	public String getName() {
		return name;
	}
	public void setName(String ame) {
		this.name = ame;
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
	public List<PhoneDTO> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, email, password, phones);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignUpDto other = (SignUpDto) obj;
		return Objects.equals(name, other.name) && Objects.equals(email, other.email)
				&& Objects.equals(password, other.password) && Objects.equals(phones, other.phones);
	}
	@Override
	public String toString() {
		return "SignUpDto [name=" + name + ", email=" + email + ", password=" + password + ", phones=" + phones + "]";
	}
	
	
	
}
