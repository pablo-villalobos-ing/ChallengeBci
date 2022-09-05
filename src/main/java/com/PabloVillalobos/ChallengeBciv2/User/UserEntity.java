package com.PabloVillalobos.ChallengeBciv2.User;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



import javax.persistence.Id;

@Entity
@Table(name = "user")

@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
	public UserEntity() {}
		
	public UserEntity(String name,String email,String password) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.password = password;
		this.created = new Date();
		this.isActive = true;
	}
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column
	private String password;
	
	@Column
	@CreatedDate
	private Date created = new Date();
	
	@Column(name = "is_active")
	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", email=" + email + ", password=" + password + ", created=" + created
				+ ", isActive=" + isActive + "]";
	}
	
	
	
	
}
