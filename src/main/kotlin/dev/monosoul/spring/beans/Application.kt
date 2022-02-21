package dev.monosoul.spring.beans

import dev.monosoul.spring.beans.base.Greeter
import dev.monosoul.spring.beans.kotlin.kotlinModule
import org.springframework.beans.factory.getBeansOfType
import org.springframework.boot.Banner.Mode.OFF
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args) {
        setLogStartupInfo(false)
        setBannerMode(OFF)
        addInitializers(ApplicationContextInitializer<GenericApplicationContext> {
            kotlinModule.initialize(it)
        })
    }.getBeansOfType<Greeter>().forEach { (_, greeter) ->
        greeter.sayHello()
    }
}
