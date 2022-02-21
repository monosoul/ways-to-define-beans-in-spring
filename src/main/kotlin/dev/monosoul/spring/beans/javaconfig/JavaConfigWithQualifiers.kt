package dev.monosoul.spring.beans.javaconfig

import dev.monosoul.spring.beans.base.Greeter
import dev.monosoul.spring.beans.base.HelloSupplier
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
class JavaConfigWithQualifiers {

    companion object {
        const val HELLO_SUPPLIER_BEAN_NAME = "javaConfigHelloSupplier"
    }

    @Bean(HELLO_SUPPLIER_BEAN_NAME)
    fun javaConfigHelloSupplier(): HelloSupplier = object : HelloSupplier {
        override fun getHello() = "java config with qualifiers hello"
    }

    @Bean
    fun javaConfigGreeter(
        @Qualifier(HELLO_SUPPLIER_BEAN_NAME) helloSupplier: HelloSupplier
    ): Greeter = object : Greeter(helloSupplier) {
        override fun name() = "java config with qualifiers world"
    }
}
