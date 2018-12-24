package EnigmaMachine


import spock.lang.Specification
import org.junit.experimental.categories.Category

import static org.assertj.core.api.Assertions.*

@Category(UnitTest.class)
class GearTests extends Specification {
    def "Pass through gear"() {
        given: "A new IC Gear is made"
            def gear = new Gear("IC", "DMTWSILRUYQNKFEJCAZBPGXOHV")
        expect: "The gear outputs D when A is inputted"
            assertThat(gear.passChar('A'.toCharacter()))
                    .isEqualTo('D'.toCharacter())
    }
}
