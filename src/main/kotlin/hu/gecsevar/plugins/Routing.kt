package hu.gecsevar.plugins

import hu.gecsevar.domain.auth.AuthRoutes
import hu.gecsevar.plugins.api.authApi
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        authApi(AuthRoutes())
    }
}
