package com.PabloVillalobos.ChallengeBciv2.jwt;


public class TokenDto {
	
	public TokenDto() {}
	
	public TokenDto(String token) {
		this.token = token;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
