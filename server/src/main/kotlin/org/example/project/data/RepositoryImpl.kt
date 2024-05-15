package org.example.project.data

import org.example.project.data.api.Endpoint
import org.example.project.data.datasource.PlanetsDatasource
import org.example.project.data.models.Planets
import org.example.project.domain.Repository

class RepositoryImpl(val planetsDatasource: PlanetsDatasource) : Repository {

    override suspend fun getTatooine(): Planets =
       planetsDatasource.getPlanets("1")


    override suspend fun getAlderaan(): Planets =
        planetsDatasource.getPlanets("2")


    override suspend fun getYavin(): Planets =
        planetsDatasource.getPlanets("3")

}