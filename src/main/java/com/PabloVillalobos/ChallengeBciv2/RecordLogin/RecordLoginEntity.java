package com.PabloVillalobos.ChallengeBciv2.RecordLogin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "record_login")
public class RecordLoginEntity {
	public RecordLoginEntity() {}

	public RecordLoginEntity(String idUser) {
		super();
		this.idUser = idUser;
		this.loginDate = new Date();
	}
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="id_user")
	private String idUser;
	
	@Column(name = "login_date")
	@CreatedDate
	private Date loginDate = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Override
	public String toString() {
		return "RecordLoginEntity [id=" + id + ", idUser=" + idUser + ", loginDate=" + loginDate + "]";
	}
	
	
	
	
}
