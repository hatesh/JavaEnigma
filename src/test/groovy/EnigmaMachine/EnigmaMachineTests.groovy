package EnigmaMachine

import Util.CharUtil
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
//    def "Can decrypt?"() {
//        given: "there are two enigma machines with default configs"
//            def m1 = new EnigmaMachine()
//            def m2 = new EnigmaMachine()
//        when: "One encodes plaintext and the other encodes the cipher text"
//            def plain = "H"
//            def cipher = m1.encode(plain)
//            def decoded = m2.encode(cipher)
//        then: "They should be the same"
//            assertThat(decoded).isEqualTo(plain)
//    }
}
