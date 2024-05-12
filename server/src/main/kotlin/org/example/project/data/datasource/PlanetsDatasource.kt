package org.example.project.data.datasource

import org.example.project.data.api.Endpoint
import org.example.project.data.models.Planets
import org.slf4j.Logger

class PlanetsDatasource(val endpoint: Endpoint,val logger: Logger){

    private val planets = HashMap<String, Planets>()


    suspend fun getPlanets(planetId: String): Planets {
        if (planets.containsKey(planetId)) {
            logger.info("Cache hit for planet $planetId")
            return planets[planetId]!!
        }
        val planet = endpoint.getPlanets(planetId)
        logger.info("fetched $planetId")
        planets[planetId] = planet
        return planet
    }

    fun clearCache() {
        planets.clear()
    }

}