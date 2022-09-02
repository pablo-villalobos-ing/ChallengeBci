package com.PabloVillalobos.ChallengeBciv2.Auth;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
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
	private static final Logger logger = LoggerFactory.logger(AuthController.class);
	
	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/signup")
	public UserDto singUp(@Validated @RequestBody SignUpDto signUpDto) throws Exception {	
		return authService.createUser(signUpDto);		
		}
	
	@PostMapping("/login")
	public LoggedUserDto login(@RequestBody TokenDto token) throws Exception {		
		return  authService.login(token.getToken());
		
	}
}
