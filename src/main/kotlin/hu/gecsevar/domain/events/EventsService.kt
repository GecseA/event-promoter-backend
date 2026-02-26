package hu.gecsevar.domain.events

import hu.gecsevar.domainEvents.AuthEvent
import hu.gecsevar.domainEvents.EventPublisherImpl
import hu.gecsevar.domainEvents.EventsEvent

class EventsService(
    private val repository: EventsRepository
) {

    init {
        EventPublisherImpl.addObserver(EventsEvent::class) {
            if (it is EventsEvent) {
                println("Event received: $it")
            }
        }
    }
}