package com.PabloVillalobos.ChallengeBciv2.Phone;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "phone")

public class PhoneEntity {
	
	public PhoneEntity() {}
	
	
	public PhoneEntity(String idUser, Long number, Integer cityCode, String countryCode) {		
		this.idUser = idUser;
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}


	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "id_user")
	private String idUser;
	
	@Column(name="number")
	private Long number;
	
	@Column(name = "city_code")
	private Integer cityCode;
	
	@Column(name="country_code")
	private String countryCode;

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
	
	
	
}
