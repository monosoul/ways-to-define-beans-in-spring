package dev.monosoul.spring.beans.javaconfig

import dev.monosoul.spring.beans.base.Greeter
import dev.monosoul.spring.beans.base.HelloSupplier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JavaConfigProxiedMethods {

    @Bean
    fun proxiedJavaConfigHelloSupplier(): HelloSupplier = object : HelloSupplier {
        override fun getHello() = "proxied java config hello"
    }

    @Bean
    fun proxiedJavaConfigGreeter(): Greeter = object : Greeter(proxiedJavaConfigHelloSupplier()) {
        override fun name() = "proxied java config world"
    }
}
