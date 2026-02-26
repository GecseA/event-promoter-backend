package hu.gecsevar.domain.registration

import hu.gecsevar.plugins.api.RegistrationsApi
import io.ktor.server.application.*
import org.slf4j.LoggerFactory

class RegistrationRoutes: RegistrationsApi {

    private val logger = LoggerFactory.getLogger("RegistrationRoutes")
    private val repository = RegistrationRepository()
    private val service = RegistrationService(repository)

    override suspend fun eventsEventIdRegistrationsGet(call: ApplicationCall) {
        TODO("Not yet implemented")
    }

    override suspend fun eventsEventIdRegistrationsPost(call: ApplicationCall) {
        TODO("Not yet implemented")
    }
}
