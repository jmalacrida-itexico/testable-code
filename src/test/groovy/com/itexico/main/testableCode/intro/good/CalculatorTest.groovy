package com.itexico.main.testableCode.intro.good

import spock.lang.Specification

class CalculatorTest extends Specification {

    def "test total price"() {
        given: "a calculator"
        def calculator = new Calculator()

        when: "I request the total price based on parts, service and discount"
        def total = calculator.getTotal(10.0, 20.00, 0.5)

        then: "it is properly calculated"
        total == 29.5
    }

}
