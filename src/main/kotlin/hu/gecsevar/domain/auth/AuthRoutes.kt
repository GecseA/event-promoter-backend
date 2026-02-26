package hu.gecsevar.domain.auth

import hu.gecsevar.plugins.api.AuthApi
import io.ktor.server.application.*
import org.slf4j.LoggerFactory

class AuthRoutes: AuthApi {

    private val logger = LoggerFactory.getLogger("AuthRoutes")
    private val repository = AuthRepository()
    private val service = AuthService(repository)

    override suspend fun authLoginPost(call: ApplicationCall) {
        TODO("Not yet implemented")
    }

    override suspend fun authSignupPost(call: ApplicationCall) {
        TODO("Not yet implemented")
    }
}
