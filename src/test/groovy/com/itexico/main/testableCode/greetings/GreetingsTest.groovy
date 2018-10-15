package com.itexico.main.testableCode.greetings

import spock.lang.Specification

import java.time.LocalTime

class GreetingsTest extends Specification {
    def "Say hello"() {
        given: "a greetings service"
        def greetings = new Greetings()

        when: "I request a greeting"
        def hello = greetings.sayHello()

        then: "it matches with the moment of the day"
        def now = LocalTime.now()
        if (now.isAfter(LocalTime.of(0, 0)) && now.isBefore(LocalTime.of(6, 0)))
            hello == "Good night"
        else if (now.isAfter(LocalTime.of(6, 0)) && now.isBefore(LocalTime.of(12, 0)))
            hello == "Good morning"
        else if (now.isAfter(LocalTime.of(12, 0)) && now.isBefore(LocalTime.of(19, 0)))
            hello == "Good afternoon"
        else
            hello == "Good evening"
    }
}
