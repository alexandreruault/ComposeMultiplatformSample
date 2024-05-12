package org.example.project.presentation

import io.ktor.http.HttpStatusCode
import io.ktor.http.HttpStatusCode.Companion.InternalServerError
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import org.example.project.domain.Interactor
import org.koin.java.KoinJavaComponent.inject
import io.ktor.server.routing.*
import org.example.project.util.Either

fun Routing.getTatooine() {

    val interactor: Interactor by inject(Interactor::class.java)

    route("/planets") {

        get("/tatooine") {
            when (val result = interactor.getTatooine()) {
                is Either.Right -> call.respond(result.b)
                is Either.Left -> call.respond(
                    InternalServerError,
                    result.a.localizedMessage
                )

            }
        }

    }

}
