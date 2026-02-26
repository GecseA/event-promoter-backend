package hu.gecsevar.domainEvents

import io.ktor.util.reflect.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass

interface EventPublisher {
    fun publish(event: DomainEvent)
    fun addObserver(eventType: KClass<out DomainEvent>, observer: (DomainEvent) -> Unit)
}

object EventPublisherImpl : EventPublisher {

    val observers: ConcurrentHashMap<KClass<out DomainEvent>, MutableList<(DomainEvent) -> Unit>> = ConcurrentHashMap()

    override fun publish(event: DomainEvent) {
        println("Event published: $event")

        observers.forEach { (key, value) ->
            if (event::class == key || event.instanceOf(key)) {
                value.forEach {
                    it(event)
                }
            }
        }
    }

    override fun addObserver(eventType: KClass<out DomainEvent>, observer: (DomainEvent) -> Unit) {
        observers.getOrPut(eventType) {
            mutableListOf()
        }.add(observer)
    }
}

