package com.PabloVillalobos.ChallengeBciv2.Auth;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.PabloVillalobos.ChallengeBciv2.Phone.PhoneDTO;
import com.PabloVillalobos.ChallengeBciv2.Phone.PhoneEntity;
import com.PabloVillalobos.ChallengeBciv2.Phone.PhoneRepository;
import com.PabloVillalobos.ChallengeBciv2.RecordLogin.RecordLoginEntity;
import com.PabloVillalobos.ChallengeBciv2.RecordLogin.RecordLoginRepository;
import com.PabloVillalobos.ChallengeBciv2.User.UserDto;
import com.PabloVillalobos.ChallengeBciv2.User.UserEntity;
import com.PabloVillalobos.ChallengeBciv2.User.UserRepository;
import com.PabloVillalobos.ChallengeBciv2.jwt.JwtProvider;



public class AuthServiceImpl implements AuthService {

	private static final Logger logger = LoggerFactory.logger(AuthServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private RecordLoginRepository recordLoginRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public UserDto createUser(SignUpDto signUpDto) throws Exception {
		
		Optional<UserEntity> exist= userRepository.findByEmail(signUpDto.getEmail());
		if (!exist.isPresent()) {
			String password = passwordEncoder.encode(signUpDto.getPassword());
			UserEntity newUser = new UserEntity(signUpDto.getName(),signUpDto.getEmail(),password);			
			
			newUser = userRepository.save(newUser);	
			logger.info("usuario creado"+newUser.getId());
			
			if (signUpDto.getPhones().size() > 0) {
				createUserPhone(newUser.getId(), signUpDto.getPhones());
			}			
			return new UserDto(newUser.getId(),newUser.getCreated(), newUser.getIsActive(), findLastLogin(newUser.getId()), jwtProvider.createToken(newUser));
			
			
		} else {
			throw new Exception(signUpDto.getEmail() +" Correo ya registrado para un usuario :"+signUpDto.getEmail());			
		}
	}
	
	@Override
	public void createUserPhone(final String idUser,List<PhoneDTO> phoneList) {
		phoneList.forEach((final PhoneDTO phone)-> {
			PhoneEntity addphone = new PhoneEntity(idUser, phone.getNumber(), phone.getCityCode(), phone.getCountryCode());
			phoneRepository.save(addphone);
		});
	}
	
	@Override
	public LoggedUserDto login(String token) throws Exception {	
		if (jwtProvider.validate(token)) {
			String idUserToken = jwtProvider.getUserIdFromToken(token);
			Optional<UserEntity> exist= userRepository.findById(idUserToken);
			if (exist.isPresent()) {
				LoggedUserDto response = new LoggedUserDto(exist.get());
				response.setLastLogin(findLastLogin(exist.get().getId()));
				response.setToken(jwtProvider.createToken(exist.get()));
				response.setPhones(ListfindPhoneFromUser(exist.get().getId()));
				
				recordLogin(exist.get().getId());
				
				return response;
				
			} else {
				throw new Exception("Error en Credenciales: Usuario no registrado");
			}
			
			
		} else {
			throw new Exception("Error en Credenciales: Token inválido");
		}
		
		
	}
	
	@Override
	public void recordLogin(String idUser) {
		recordLoginRepository.save(new RecordLoginEntity(idUser));
	}
	
	public  Date findLastLogin(String idUser) {
		logger.info("usuario last loging : "+ idUser);
		Optional<RecordLoginEntity> lastLogin = recordLoginRepository.findTopByIdUserOrderByLoginDateDesc(idUser);
			
		if (lastLogin.isPresent()) {
			logger.debug("DATOS DEL JPA: "+ lastLogin.get().toString());
			return lastLogin.get().getLoginDate();
		} else {
			return null;
		}
	}
	
	public List<PhoneDTO> ListfindPhoneFromUser(String idUser) {
		List<PhoneEntity> phones = phoneRepository.findByIdUser(idUser);
	logger.info("cantidad de numeros encontrados: "+phones.size());
		return  phones.stream().map(PhoneDTO:: new).collect(Collectors.toList());
		
	}
	
	
	
}
