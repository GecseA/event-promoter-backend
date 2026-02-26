package hu.gecsevar.domain.events

import hu.gecsevar.plugins.api.AuthApi
import hu.gecsevar.plugins.api.EventsApi
import io.ktor.server.application.*
import io.ktor.server.html.Placeholder
import io.ktor.server.html.Template
import io.ktor.server.html.TemplatePlaceholder
import io.ktor.server.html.insert
import io.ktor.server.html.respondHtmlTemplate
import kotlinx.html.FlowContent
import kotlinx.html.HTML
import kotlinx.html.article
import kotlinx.html.body
import kotlinx.html.footer
import kotlinx.html.h1
import kotlinx.html.h2
import kotlinx.html.head
import kotlinx.html.header
import kotlinx.html.p
import kotlinx.html.style
import kotlinx.html.title
import org.slf4j.LoggerFactory
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class EventsRoutes: EventsApi {

    private val logger = LoggerFactory.getLogger("EventsRoutes")
    private val repository = EventsRepository()
    private val service = EventsService(repository)

    override suspend fun eventsEventIdAccessGet(call: ApplicationCall) {
        TODO("Not yet implemented")
    }

    override suspend fun eventsEventIdGet(call: ApplicationCall) {
        TODO("Not yet implemented")
    }

    @OptIn(ExperimentalUuidApi::class)
    override suspend fun eventsGet(call: ApplicationCall) {

        val eventId = call.parameters["id"]?.let {
            Uuid.fromByteArray(it.toByteArray())
        } ?: Uuid.generateV4()
        val sampleEvent = Event(
            id = eventId,
            title = "Sample Conference $eventId",
            date = "2026-02-21",
            location = "Budapest, Hungary",
            description = "A template-driven event page demo.",
            subtitle = TODO(),
            isVIP = TODO(),
            hero = TODO(),
            organizer = TODO(),
            sessions = TODO(),
            registration = TODO(),
            layoutId = TODO()
        )
        call.respondHtmlTemplate(LayoutTemplate()) {
            content {
                title { +sampleEvent.title }
                date { +"Date: ${sampleEvent.date}" }
                location { +"Location: ${sampleEvent.location}" }
                description { +sampleEvent.description }
            }
        }
    }
}

class LayoutTemplate : Template<HTML> {
    val content = TemplatePlaceholder<EventPageTemplate>()
    override fun HTML.apply() {
        head {
            title { +"Event Page" }
            style { +"body { font-family: Arial; }" }
        }
        body {
            header {
                h1 { +"Event Management" }
            }
            insert(EventPageTemplate(), content)
            footer { +"Powered by Ktor" }
        }
    }
}

class EventPageTemplate : Template<FlowContent> {
    val title = Placeholder<FlowContent>()
    val date = Placeholder<FlowContent>()
    val location = Placeholder<FlowContent>()
    val description = Placeholder<FlowContent>()
    override fun FlowContent.apply() {
        article {
            h2 { insert(title) }
            p { insert(date) }
            p { insert(location) }
            p { insert(description) }
        }
    }
}