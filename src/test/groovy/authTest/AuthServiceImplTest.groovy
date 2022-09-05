package authTest

import org.springframework.security.crypto.password.PasswordEncoder

import com.PabloVillalobos.ChallengeBciv2.Auth.AuthServiceImpl
import com.PabloVillalobos.ChallengeBciv2.Phone.PhoneRepository
import com.PabloVillalobos.ChallengeBciv2.RecordLogin.RecordLoginEntity
import com.PabloVillalobos.ChallengeBciv2.RecordLogin.RecordLoginRepository
import com.PabloVillalobos.ChallengeBciv2.User.UserRepository
import com.PabloVillalobos.ChallengeBciv2.jwt.JwtProvider

import spock.lang.Shared
import spock.lang.Specification

class AuthServiceImplTest extends Specification {
	@Shared
	AuthServiceImpl service = Stub(){
		findLastLogin("idUserUUID") >>> [new Date(), null]
	}	
	

	def "find last login with Date"(){		
		when:			
			Date responseDate = new Date()
			println(responseDate)
			service.findfindLastLogin("idUserUUID") >> responseDate
		then:
		println("fin test")		
	}
	
	def "find last login isNull"(){
		when:
			Date responseDate = null
			println(responseDate)
			service.findfindLastLogin("idUserUUID") >> responseDate
		then:
		println("fin test")
	}
	
	
	
	
}
