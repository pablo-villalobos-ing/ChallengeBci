package com.PabloVillalobos.ChallengeBciv2.Auth;

import java.util.List;

import com.PabloVillalobos.ChallengeBciv2.Phone.PhoneDTO;
import com.PabloVillalobos.ChallengeBciv2.User.UserDto;

public interface AuthService {
	
	/**
	 * Add a new user if the dto complete the required factors
	 * @param signUpDto
	 * @return userDto
	 * @throws Exception 
	 */

	UserDto createUser(SignUpDto signUpDto) throws Exception;

	void createUserPhone(String idUser, List<PhoneDTO> phoneList);

	

	void recordLogin(String idUser);

	LoggedUserDto login(String token) throws Exception;

}
