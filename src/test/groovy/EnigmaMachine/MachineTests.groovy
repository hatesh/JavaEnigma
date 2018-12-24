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
}

