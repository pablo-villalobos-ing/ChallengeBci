import spock.lang.Specification

class PasswordEncriptTest extends Specification{
	def "push and pop single element"() {

		given:
		Stack stack = new Stack()

		when:
		stack.push(11)

		then:
		stack.pop() == 11
		stack.size() == 0
	}
}