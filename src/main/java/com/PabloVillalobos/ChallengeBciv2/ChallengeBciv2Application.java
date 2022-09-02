package com.PabloVillalobos.ChallengeBciv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.PabloVillalobos.ChallengeBciv2.Auth.AuthServiceImpl;

@SpringBootApplication
public class ChallengeBciv2Application {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeBciv2Application.class, args);
	}
	
	@Bean
	public AuthServiceImpl signUpService() {
		return new AuthServiceImpl();
	}

}
