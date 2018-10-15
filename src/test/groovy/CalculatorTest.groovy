import com.itexico.main.testableCode.intro.good.Calculator
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class CalculatorTest extends Specification {
    def "three plus two should be five"() {
        //Arrange
        given: "a calculator"
        def calculator = new Calculator()

        //Act
        when: "I sum 3 and 2"
        def result = calculator.sum(3, 2)

        //Assert
        then: "the result should be 5"
        result == 5
    }
}
