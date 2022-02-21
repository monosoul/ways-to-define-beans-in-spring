package dev.monosoul.spring.beans.base

abstract class Greeter(
    private val helloSupplier: HelloSupplier
) {
    abstract fun name(): String
    fun sayHello() {
        println("${helloSupplier.getHello()} ${name()}")
    }
}
