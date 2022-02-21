package dev.monosoul.spring.beans.kotlin

import dev.monosoul.spring.beans.base.Greeter
import dev.monosoul.spring.beans.base.HelloSupplier
import org.springframework.context.support.beans

val kotlinModule = beans {
    val supplierBeanName = "kotlinHelloSupplier"
    bean<HelloSupplier>(name = supplierBeanName) {
        object : HelloSupplier {
            override fun getHello() = "kotlin hello"
        }
    }
    bean<Greeter>("kotlinGreeter") {
        object : Greeter(ref(name = supplierBeanName)) {
            override fun name() = "kotlin world"
        }
    }
}
