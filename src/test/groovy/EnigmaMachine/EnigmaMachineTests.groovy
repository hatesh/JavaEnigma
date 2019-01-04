package EnigmaMachine


import spock.lang.Specification
import org.junit.experimental.categories.Category

import static org.assertj.core.api.Assertions.*

@Category(UnitTest.class)
class EnigmaMachineTests extends Specification {
    def "Running the default config should produce the same cipher test"() {
        given: "there are two enigma machines with default configs"
            def m1 = new EnigmaMachine()
            def m2 = new EnigmaMachine()
        when: "encoding the same message"
            def msg1 = m1.encode("HELLO WORLD")
            def msg2 = m2.encode("HELLO WORLD")
        then: "They should be the same"
            assertThat(msg1).isEqualTo(msg2)
    }
//    def "Enigma Test 1"() {
//        given: "Enigma Machine is set up accurate to the example"
//            def plugBoard = new PlugBoard('Empty')
//            def gear3 = new Gear("III", "EKMFLGDQVZNTOWYHXUSPAIBRCJ")
//            def gear2 = new Gear("II", "AJDKSIRUXBLHWTMCQGZNPYFVOE")
//            def gear1 = new Gear("I", "BDFHJLCPRTXVZNYEIWGAKMUSQO")
//            def reflector = new Gear("wide B-reflector", "YRUHQSLDPXNGOKMIEBFZCWVJAT")
//            def gearBox = new GearBox(gear3, gear2, gear1, reflector)
//            def enigmaMachine = new EnigmaMachine(plugBoard, gearBox)
//            print enigmaMachine.toString()
//        expect: "encoding AAAAA to return BDZGO"
//            assertThat(enigmaMachine.encode("AAAAA")).isEqualTo("BDZGO")
//    }
//    def "Enigma Test 2"() {
//        given: "Enigma Machine is set up accurate to the example"
//            def plugBoard = new PlugBoard('Empty')
//            def gear3 = new Gear("III", "EKMFLGDQVZNTOWYHXUSPAIBRCJ")
//            def gear2 = new Gear("II", "AJDKSIRUXBLHWTMCQGZNPYFVOE")
//            def gear1 = new Gear("I", "BDFHJLCPRTXVZNYEIWGAKMUSQO")
//            def reflector = new Gear("wide B-reflector", "YRUHQSLDPXNGOKMIEBFZCWVJAT")
//            def gearBox = new GearBox(gear3, gear2, gear1, reflector)
//            def enigmaMachine = new EnigmaMachine(plugBoard, gearBox)
//            print enigmaMachine.toString()
//        expect: "encoding AAAAA to return BDZGO"
//            assertThat(enigmaMachine.encode("AAAAA")).isEqualTo("BDZGO")
//    }
    def "Can decrypt 1"() {
        given: "there are two enigma machines with default configs"
            def m1 = new EnigmaMachine()
            def m2 = new EnigmaMachine()
        when: "One encodes plaintext and the other encodes the cipher text"
            def plain = "HELLO WORLD"
            def cipher = m1.encode(plain)
            def decoded = m2.encode(cipher)
        then: "They should be the same"
            assertThat(decoded).isEqualTo(plain)
    }
    def "Can decrypt 2"() {
        given: "there are two enigma machines with the same configs"
            def plugBoard = new PlugBoard('Empty')
            def gear3 = new Gear("III", "BDFHJLCPRTXVZNYEIWGAKMUSQO")
            def gear2 = new Gear("II", "AJDKSIRUXBLHWTMCQGZNPYFVOE")
            def gear1 = new Gear("I", "EKMFLGDQVZNTOWYHXUSPAIBRCJ")
            def reflector = new Gear("wide B-reflector", "YRUHQSLDPXNGOKMIEBFZCWVJAT")
            def gearBox = new GearBox(gear3, gear2, gear1, reflector)
            def m1 = new EnigmaMachine(plugBoard, gearBox)
            plugBoard = new PlugBoard('Empty')
            gear3 = new Gear("III", "BDFHJLCPRTXVZNYEIWGAKMUSQO")
            gear2 = new Gear("II", "AJDKSIRUXBLHWTMCQGZNPYFVOE")
            gear1 = new Gear("I", "EKMFLGDQVZNTOWYHXUSPAIBRCJ")
            reflector = new Gear("wide B-reflector", "YRUHQSLDPXNGOKMIEBFZCWVJAT")
            gearBox = new GearBox(gear3, gear2, gear1, reflector)
            def m2 = new EnigmaMachine(plugBoard, gearBox)
        when: "One encodes plaintext and the other encodes the cipher text"
            def plain = "HELLO WORLD"
            def cipher = m1.encode(plain)
            def decoded = m2.encode(cipher)
        then: "They should be the same"
            assertThat(decoded).isEqualTo(plain)
    }
}
