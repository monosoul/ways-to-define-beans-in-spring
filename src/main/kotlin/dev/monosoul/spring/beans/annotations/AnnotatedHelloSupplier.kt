package dev.monosoul.spring.beans.annotations

import dev.monosoul.spring.beans.base.HelloSupplier
import org.springframework.stereotype.Component

@Component
class AnnotatedHelloSupplier : HelloSupplier {
    override fun getHello() = "Annotated hello"
}
