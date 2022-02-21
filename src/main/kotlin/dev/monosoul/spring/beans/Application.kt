package dev.monosoul.spring.beans

import dev.monosoul.spring.beans.base.Greeter
import org.springframework.beans.factory.getBeansOfType
import org.springframework.boot.Banner.Mode.OFF
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args) {
        setLogStartupInfo(false)
        setBannerMode(OFF)
    }.getBeansOfType<Greeter>().forEach { (_, greeter) ->
        greeter.sayHello()
    }
}
