package hu.gecsevar.domain.registration

import hu.gecsevar.domainEvents.AuthEvent
import hu.gecsevar.domainEvents.EventPublisherImpl
import hu.gecsevar.domainEvents.RegistrationEvent

class RegistrationService(
    private val repository: RegistrationRepository
) {

    init {
        EventPublisherImpl.addObserver(RegistrationEvent::class) {
            if (it is RegistrationEvent) {
                println("Event received: $it")
            }
        }
    }
}