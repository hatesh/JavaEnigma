package EnigmaMachine

import Util.CharUtil
import Util.UnitTest
import spock.lang.Specification
import org.junit.experimental.categories.Category

import static org.assertj.core.api.Assertions.*

@Category(UnitTest.class)
class UtilTests extends Specification {
    def "Adding two char arrays"() {
        given: "there are two char arrays"
            def c1 = "char".toCharArray()
            def c2 = "array".toCharArray()
        expect: "The util function should combine them"
            assertThat(CharUtil.arrayCombine(c1, c2)).isEqualTo('chararray'.toCharArray())
    }
    def "Appending to a char array"() {
        given: ""
            def arr = "chararra".toCharArray()
            def c = 'y'.toCharacter()
        expect: "The util function should combine them"
            assertThat(CharUtil.arrayAppend(arr, c)).isEqualTo('chararray'.toCharArray())
    }
    def "Prefixing a char array"() {
        given: ""
            def arr = "hararray".toCharArray()
            def c = 'c'.toCharacter()
        expect: "The util function should combine them"
            assertThat(CharUtil.arrayPrefix(arr, c)).isEqualTo('chararray'.toCharArray())
    }
}
