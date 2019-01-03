package EnigmaMachine


import spock.lang.Specification
import org.junit.experimental.categories.Category

import static org.assertj.core.api.Assertions.*

@Category(UnitTest.class)
class GearBoxTests extends Specification {
    def "Pass through gear"() {
        given: "A new IC Gear is made"
            def gear = new Gear("IC", "DMTWSILRUYQNKFEJCAZBPGXOHV")
        expect: "The gear outputs D when A is inputted"
            assertThat(gear.passInputChar('A'.toCharacter()))
                    .isEqualTo('D'.toCharacter())
    }
    def "Pass through default gearbox"() {
        given: "The default gearbox is made"
            def gearBox = new GearBox()
        expect: "The gearBox outputs O when A is inputted"
            assertThat(gearBox.encodeCharWithShift('A'.toCharacter()))
                    .isEqualTo('V'.toCharacter())
    }

}
