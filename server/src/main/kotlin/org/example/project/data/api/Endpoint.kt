package org.example.project.data.api

import io.ktor.client.call.*
import io.ktor.client.request.*
import org.example.project.data.models.Planets

class Endpoint {

    suspend fun getPlanets(planetId: String): Planets =
            httpClient.get("planets/$planetId").body<Planets>()

}