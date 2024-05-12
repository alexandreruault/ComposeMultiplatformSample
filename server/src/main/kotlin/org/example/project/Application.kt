package org.example.project

import SERVER_PORT
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import org.example.project.data.dataModule
import org.example.project.domain.domainModules
import org.example.project.presentation.getTatooine
import org.example.project.data.datasource.loggingModules
import org.example.project.presentation.getAlderaan
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(dataModule, domainModules, loggingModules)
    }

    embeddedServer(Netty, port = SERVER_PORT, host = "127.0.0.1", module = Application::module).start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }
    routing {
        get("/greet") {
            call.respondText("Hello, world!", ContentType.Text.Plain, HttpStatusCode.OK)
        }
        getTatooine()
        getAlderaan()
    }
}
