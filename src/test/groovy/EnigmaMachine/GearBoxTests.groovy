package EnigmaMachine

import Exceptions.IncorrectCypherbetException
import Exceptions.MaxPopulationException
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
        expect: "The gearBox outputs G when A is inputted"
            assertThat(gearBox.encodeCharWithShift('A'.toCharacter()))
                    .isEqualTo('G'.toCharacter())
    }
    def "New Gear doesn't exceed max pairs"() {
        given: "A new gear"
            def gear = new Gear("IC", "DMTWSILRUYQNKFEJCAZBPGXOHV")
        when: "Attempt to add another plug"
            gear.addMap(new Plug())
        then: "A MaxPopulationException is thrown"
            thrown(MaxPopulationException)
    }
    def "Create Gear with incorrect cipherbet"() {
        given: "A new gear is made"
            def gear = new Gear("IC", "DMTWSILRUYQNKFEJCAZBPGXOHV")
        when: "an incorrect cipherbet is mapped"
            gear.setMappings("BAD")
        then: "an IncorrectCypherbetException is thrown"
            thrown(IncorrectCypherbetException)
    }

}
