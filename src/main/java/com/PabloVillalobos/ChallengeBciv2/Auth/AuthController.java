package com.PabloVillalobos.ChallengeBciv2.Auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PabloVillalobos.ChallengeBciv2.User.UserDto;
import com.PabloVillalobos.ChallengeBciv2.jwt.TokenDto;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/public/auth")

public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/sign-up")
	public UserDto singUp(@Validated @RequestBody SignUpDto signUpDto) throws Exception {	
		return authService.createUser(signUpDto);		
		}
	
	@PostMapping("/login")
	public LoggedUserDto login(@RequestBody TokenDto token) throws Exception {		
		return  authService.login(token.getToken());
		
	}
}
