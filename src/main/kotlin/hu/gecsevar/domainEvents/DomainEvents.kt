package hu.gecsevar.domainEvents

sealed interface DomainEvent {}

data class AuthEvent(val user: String) : DomainEvent