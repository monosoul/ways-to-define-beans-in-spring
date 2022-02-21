package dev.monosoul.spring.beans.beandefinitionregistrypostprocessor

import dev.monosoul.spring.beans.base.Greeter
import dev.monosoul.spring.beans.base.HelloSupplier
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.beans.factory.support.BeanDefinitionBuilder
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor
import org.springframework.beans.factory.support.RootBeanDefinition
import org.springframework.stereotype.Component

@Component
class GreeterBeanDefinitionRegistrer : BeanDefinitionRegistryPostProcessor {
    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) = Unit

    override fun postProcessBeanDefinitionRegistry(registry: BeanDefinitionRegistry) {
        val helloSupplierBeanName = "beanDefinitionHelloSupplier"
        registry.registerBeanDefinition(
            helloSupplierBeanName,
            BeanDefinitionBuilder
                .genericBeanDefinition(HelloSupplier::class.java) {
                    object : HelloSupplier {
                        override fun getHello() = "bean definition hello"
                    }
                }
                .setScope(BeanDefinition.SCOPE_SINGLETON)
                .beanDefinition
        )

        registry.registerBeanDefinition(
            "beanDefinitionGreeter",
            BeanDefinitionBuilder
                .rootBeanDefinition(BeanDefinitionGreeter::class.java)
                .setScope(BeanDefinition.SCOPE_SINGLETON)
                .addConstructorArgReference(helloSupplierBeanName)
                .beanDefinition
                .let { it as RootBeanDefinition }
                .apply {
                    targetType = Greeter::class.java
                }
        )
    }

    class BeanDefinitionGreeter(helloSupplier: HelloSupplier) : Greeter(helloSupplier) {
        override fun name() = "bean definition world"
    }
}
