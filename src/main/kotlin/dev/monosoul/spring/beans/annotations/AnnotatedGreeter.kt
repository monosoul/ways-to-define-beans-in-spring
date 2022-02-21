package dev.monosoul.spring.beans.annotations

import dev.monosoul.spring.beans.base.Greeter
import org.springframework.stereotype.Component

@Component
class AnnotatedGreeter(
    helloSupplier: AnnotatedHelloSupplier
) : Greeter(helloSupplier) {
    override fun name() = "annotated world"
}
