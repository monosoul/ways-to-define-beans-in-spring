package dev.monosoul.spring.beans.beanfactorypostprocessor

import dev.monosoul.spring.beans.base.Greeter
import dev.monosoul.spring.beans.base.HelloSupplier
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.beans.factory.getBean
import org.springframework.stereotype.Component

@Component
class GreeterBeanRegistrer : BeanFactoryPostProcessor {
    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
        val helloSupplierBeanName = "factoryRegisteredHelloSupplier"
        beanFactory.registerSingleton(
            helloSupplierBeanName,
            object : HelloSupplier {
                override fun getHello() = "factory registered hello"
            }
        )
        beanFactory.registerSingleton(
            "factoryRegisteredGreeter",
            object : Greeter(beanFactory.getBean<HelloSupplier>(helloSupplierBeanName)) {
                override fun name() = "factory registered world"
            }
        )
    }
}
