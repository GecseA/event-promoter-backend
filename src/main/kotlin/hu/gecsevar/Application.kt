package hu.gecsevar

import hu.gecsevar.plugins.configureHTTP
import hu.gecsevar.plugins.configureRouting
import hu.gecsevar.plugins.configureSecurity
import hu.gecsevar.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.cio.EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureSecurity()
    configureSerialization()
    configureRouting()
}
