package EnigmaMachine

import spock.lang.Specification
import org.junit.experimental.categories.Category

// import static org.hamcrest.Matchers.*
// import static org.hamcrest.Matchers.either
// import static org.hamcrest.MatcherAssert.assertThat

import static org.assertj.core.api.Assertions.*;

@Category(UnitTest.class)
class MachineTests extends Specification {
    def "Default plug input"() {
        given: "A new plug is made"
            def plug = new Plug()
        expect: "The default input character A is set"
            plug.getInputChar() == 'A'.toCharacter()
    }
    def "Test auto set integers"() {
        given: "A new plug is made with letters"
            def plug = new Plug('D'.toCharacter(), 'P'.toCharacter())
        expect: "The integer values should match"
            plug.getInputInt() == 3
    }
    def "Test auto set characters"() {
        given: "A new plug is made with letters"
            def plug = new Plug(3, 13)
        expect: "The input integer should be D"
            plug.getInputChar() == 'D'.toCharacter()
        and: "The output character should be N"
            plug.getOutputChar() == 'N'.toCharacter()
    }
    def "Random plugboard doesn't have any repeating letters"() {
        given: "A random plugboard"
            def plugboard = new Plugboard()
        expect: "No duplicate values in the used letters"
            assertThat(plugboard.getPlugged()).doesNotHaveDuplicates()
    }
}

