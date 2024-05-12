package org.example.project.data

import org.example.project.data.api.Endpoint
import org.example.project.data.datasource.PlanetsDatasource
import org.example.project.domain.Repository
import org.koin.dsl.module

val dataModule = module {
    single { Endpoint() } // This is the same as `single<Endpoint> { Endpoint() }`
    single { PlanetsDatasource(endpoint = get(), logger = get()) }
    single<Repository> { RepositoryImpl(planetsDatasource = get()) }
}