package hu.gecsevar.domainEvents

sealed interface DomainEvent {}

data class AuthEvent(val user: String) : DomainEvent
data class EventsEvent(val id: Int) : DomainEvent
data class RegistrationEvent(val user: String) : DomainEvent