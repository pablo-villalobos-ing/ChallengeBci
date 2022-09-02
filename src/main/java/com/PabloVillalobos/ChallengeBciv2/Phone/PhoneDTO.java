package com.PabloVillalobos.ChallengeBciv2.Phone;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;

public class PhoneDTO {
	
	public PhoneDTO() {}
	
	public PhoneDTO(Long id, String idUser, Long number, Integer cityCode, String countryCode) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}
	public PhoneDTO(PhoneEntity p) {
		this.id =p.getId();
		this.idUser = p.getIdUser();
		this.number = p.getNumber();
		this.cityCode = p.getCityCode();
		this.countryCode = p.getCountryCode();
	}

	private Long id;	
	private String idUser;
	private Long number;
	private Integer cityCode;	
	private String countryCode;
	
	
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
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
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
	@Override
	public int hashCode() {
		return Objects.hash(cityCode, countryCode, id, idUser, number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneDTO other = (PhoneDTO) obj;
		return Objects.equals(cityCode, other.cityCode) && Objects.equals(countryCode, other.countryCode)
				&& Objects.equals(id, other.id) && Objects.equals(idUser, other.idUser)
				&& Objects.equals(number, other.number);
	}
	@Override
	public String toString() {
		return "PhoneDTO [id=" + id + ", idUser=" + idUser + ", number=" + number + ", cityCode=" + cityCode
				+ ", countryCode=" + countryCode + "]";
	}
	
	
}
