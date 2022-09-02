package com.PabloVillalobos.ChallengeBciv2.Auth;

import java.util.Date;
import java.util.List;

import com.PabloVillalobos.ChallengeBciv2.Phone.PhoneDTO;
import com.PabloVillalobos.ChallengeBciv2.User.UserEntity;

public class LoggedUserDto {
	
	public  LoggedUserDto() {}
	
	public LoggedUserDto(UserEntity u) {
		this.id = u.getId();
		this.created = u.getCreated();		
		this.isActive = u.getIsActive();
		this.name = u.getName();
		this.email = u.getEmail();
		this.password = u.getPassword();
	}	

	private String id;
	private Date created;
	private Date lastLogin;
	private String token;
	private Boolean isActive;
	private String name;
	private String email;
	private String password;
	private List<PhoneDTO> phones;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
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
	public List<PhoneDTO> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}
	
	
}
