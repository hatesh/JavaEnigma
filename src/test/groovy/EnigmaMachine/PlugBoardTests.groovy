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
    def "PlugBoard pass int where input is paired"() {
        given: "PlugBoard is set up with a pair"
            def plugBoard = new PlugBoard("Custom")
            plugBoard.addPlug(new Plug(3,23))
        expect: "return 23 when 3 is passed"
            plugBoard.passInt(3) == 23
    }
    def "PlugBoard pass int where input is not paired"() {
        given: "PlugBoard is set up"
        def plugBoard = new PlugBoard("Custom")
        expect: "return 6 when 6 is passed"
        plugBoard.passInt(6) == 6
    }
    def "PlugBoard pass char where input is paired"() {
        given: "PlugBoard is set up with a pair"
        def plugBoard = new PlugBoard("Custom")
        plugBoard.addPlug(new Plug('C'.toCharacter(),'H'.toCharacter()))
        expect: "return H when C is passed"
        plugBoard.passChar('C'.toCharacter()) == 'H'.toCharacter()
    }
    def "PlugBoard pass char where input is not paired"() {
        given: "PlugBoard is set up"
        def plugBoard = new PlugBoard("Custom")
        expect: "return N when N is passed"
        plugBoard.passChar('N'.toCharacter()) == 'N'.toCharacter()
    }
}

