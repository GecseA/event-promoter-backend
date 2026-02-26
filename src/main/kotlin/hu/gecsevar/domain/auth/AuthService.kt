package hu.gecsevar.domain.auth

import hu.gecsevar.domainEvents.AuthEvent
import hu.gecsevar.domainEvents.EventPublisherImpl

class AuthService(
    private val repository: AuthRepository
) {

    init {
        EventPublisherImpl.addObserver(AuthEvent::class) {
            if (it is AuthEvent) {
                println("Event received: $it")
            }
        }
    }
}