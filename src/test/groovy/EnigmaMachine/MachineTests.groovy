package EnigmaMachine

import spock.lang.Specification
import org.junit.experimental.categories.Category

@Category(UnitTest.class)
class MachineTests extends Specification {
    def "Default plug input"() {
        given: "A new plug is made"
            def plug = new Plug()
        expect: "The default input character A is set"
            // assertThat(plug.getInputChar(), 'A')
        plug.getInputChar() == 'A'.toCharacter()
    }
    def "Test auto set values"() {
        given: "A new plug is made with letters"
            def plug = new Plug('D'.toCharacter(), 'P'.toCharacter())
        expect: "The integer values should match"
            plug.getInputInt() == 3
    }
}

