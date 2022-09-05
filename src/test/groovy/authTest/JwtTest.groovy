package authTest

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

import org.springframework.test.context.ContextConfiguration

import com.PabloVillalobos.ChallengeBciv2.PropertiesConfig
import com.PabloVillalobos.ChallengeBciv2.jwt.JwtProvider

import spock.lang.Shared
import spock.lang.Specification

@ContextConfiguration(classes = PropertiesConfig.class)
class JwtTest extends Specification {
	@Shared
	JwtProvider jwt = Stub(){
		validate("token") >>> [true, false]
		getUserIdFromToken("token") >>> ["IduserUUID","Bad Token"]
	};

	def "Validate token Ok"(){
		given:
		String token = "token"
		boolean result= jwt.validate(token)
		when:
		println("Validate token on true")
		then:
		true == result
	}
	def "Validate token Fail"(){
		given:
		String token = "token"
		boolean result= jwt.validate(token)
		when:
		println("Validate token on false")
		then:
		false == result
	}
	
	def "Get ID User Ok"(){
		when :		
		String token ="token"
		String result = jwt.getUserIdFromToken(token)
		
		then:
		println("Id User found success")
		 result == "IduserUUID"
	}
	
	def "Get ID User Fail"(){
		when :
		String token ="token"
		String result = jwt.getUserIdFromToken(token)
		
		then:
		println("Id User not found")
		 result == "Bad Token"
	}
	
	
}
