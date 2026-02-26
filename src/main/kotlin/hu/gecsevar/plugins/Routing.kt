package hu.gecsevar.plugins

import hu.gecsevar.domain.auth.AuthRoutes
import hu.gecsevar.domain.events.EventsRoutes
import hu.gecsevar.domain.registration.RegistrationRoutes
import hu.gecsevar.plugins.api.authApi
import hu.gecsevar.plugins.api.eventsApi
import hu.gecsevar.plugins.api.registrationsApi
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        authApi(AuthRoutes())
        eventsApi(EventsRoutes())
        registrationsApi(RegistrationRoutes())
    }
}
