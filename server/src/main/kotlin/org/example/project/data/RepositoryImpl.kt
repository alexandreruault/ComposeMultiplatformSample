package org.example.project.data

import org.example.project.data.api.Endpoint
import org.example.project.data.models.Planets
import org.example.project.domain.Repository

class RepositoryImpl(val endpoint: Endpoint) : Repository {
    override suspend fun getTatooine(): Planets =
       endpoint.getPlanets("1")

}