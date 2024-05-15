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

            interactor.getTatooine().fold(
                onSuccess = {
                    call.respond(it)
                },
                onFailure = {
                    call.respond(InternalServerError, it.localizedMessage)
                }
            )
        }

    }

}

fun Route.getAlderaan() {

    val interactor: Interactor by inject(Interactor::class.java)

    route("/planets") {

        get("/alderaan") {
            interactor.getAlderaan().fold(
                onSuccess = {
                    call.respond(it)
                },
                onFailure = {
                    call.respond(InternalServerError, it.localizedMessage)
                }
            )
        }
    }
}


fun Route.getYavin() {

    val interactor: Interactor by inject(Interactor::class.java)

    route("/planets") {

        get("/yavin") {
            interactor.getYavin().fold(
                onSuccess = {
                    call.respond(it)
                },
                onFailure = {
                    call.respond(InternalServerError, it.localizedMessage)
                }
            )

        }
    }

}