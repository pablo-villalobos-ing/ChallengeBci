package com.PabloVillalobos.ChallengeBciv2.User;

import java.util.Date;
import java.util.Objects;


public class UserDto {
	
	public UserDto() {}
	
	public UserDto(String id, Date created,Boolean isActive, Date lastLogin, String token ) {
		this.id = id;
		this.created = created;
		this.isActive = isActive;
		this.lastLogin = lastLogin;
		this.token = token;
	}
	
	private String id;
	private Date created;
	private Boolean isActive;
	private Date lastLogin;
	private String token;
	
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
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
	@Override
	public int hashCode() {
		return Objects.hash(created, id, isActive, lastLogin, token);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(created, other.created) && Objects.equals(id, other.id)
				&& Objects.equals(isActive, other.isActive) && Objects.equals(lastLogin, other.lastLogin)
				&& Objects.equals(token, other.token);
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", created=" + created + ", isActive=" + isActive + ", lastLogin=" + lastLogin
				+ ", token=" + token + "]";
	}
	
	
	
	
}
