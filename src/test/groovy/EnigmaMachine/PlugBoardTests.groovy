package EnigmaMachine

import Exceptions.MaxPopulationException
import spock.lang.Specification
import org.junit.experimental.categories.Category

import static org.assertj.core.api.Assertions.*

@Category(UnitTest.class)
class PlugBoardTests extends Specification {
    def "Default plug input"() {
        given: "A new plug is made"
            def plug = new Plug()
        expect: "The default input character A is set"
            assertThat(plug.getInputChar()).isEqualTo('A'.toCharacter())
    }
    def "Test auto set integers"() {
        given: "A new plug is made with letters"
            def plug = new Plug('D'.toCharacter(), 'P'.toCharacter())
        expect: "The integer values should match"
            assertThat(plug.getInputInt()).isEqualTo(3)
    }
    def "Test auto set characters"() {
        given: "A new plug is made with letters"
            def plug = new Plug(3, 13)
        expect: "The input integer should be D"
            assertThat(plug.getInputChar()).isEqualTo('D'.toCharacter())
        and: "The output character should be N"
            assertThat(plug.getOutputChar()).isEqualTo('N'.toCharacter())
    }
    def "Random plugBoard Doesn't exceed max pairs"() {
        given: "A random PlugBoard"
            def plugBoard = new PlugBoard()
        when: "Attempt to add another plug"
            plugBoard.addPlug(new Plug())
        then: "A MaxPopulationException is thrown"
            thrown(MaxPopulationException)
    }
    def "Random plugBoard doesn't have any repeating letters"() {
        given: "A random PlugBoard"
            def plugBoard = new PlugBoard()
        expect: "No duplicate values in the used letters"
            assertThat(plugBoard.getPlugged()).doesNotHaveDuplicates()
    }
    def "Default plugBoard Doesn't exceed max pairs"() {
        given: "A default PlugBoard"
            def plugBoard = new PlugBoard('Default')
        when: "Attempt to add another plug"
            plugBoard.addPlug(new Plug())
        then: "A MaxPopulationException is thrown"
            thrown(MaxPopulationException)
    }
    def "Default plugBoard doesn't have any repeating letters"() {
        given: "A default PlugBoard"
            def plugBoard = new PlugBoard('Default')
        expect: "No duplicate values in the used letters"
            assertThat(plugBoard.getPlugged()).doesNotHaveDuplicates()
    }
    def "PlugBoard pass int where input is paired"() {
        given: "PlugBoard is set up with a pair"
            def plugBoard = new PlugBoard("Custom")
            plugBoard.addPlug(new Plug(3,23))
        expect: "return 23 when 3 is passed"
            assertThat(plugBoard.passInputInt(3)).isEqualTo(23)
    }
    def "PlugBoard pass int where input is not paired"() {
        given: "PlugBoard is set up"
            def plugBoard = new PlugBoard("Custom")
        expect: "return 6 when 6 is passed"
            assertThat(plugBoard.passInputInt(6)).isEqualTo(6)
    }
    def "PlugBoard pass char where input is paired"() {
        given: "PlugBoard is set up with a pair"
            def plugBoard = new PlugBoard("Custom")
            plugBoard.addPlug(new Plug('C'.toCharacter(),'H'.toCharacter()))
        expect: "return H when C is passed"
            // plugBoard.passInputChar('C'.toCharacter()) == 'H'.toCharacter()
            assertThat((char) plugBoard.passInputChar('C'.toCharacter())).isEqualTo('H'.toCharacter())
    }
    def "PlugBoard pass char where input is not paired"() {
        given: "PlugBoard is set up"
            def plugBoard = new PlugBoard("Custom")
        expect: "return N when N is passed"
            // plugBoard.passInputChar('N'.toCharacter()) == 'N'.toCharacter()
            assertThat((char) plugBoard.passInputChar('N'.toCharacter())).isEqualTo('N'.toCharacter())
    }
}

