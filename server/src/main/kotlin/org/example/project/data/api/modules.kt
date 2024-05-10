package org.example.project.data.api

import org.example.project.data.RepositoryImpl
import org.example.project.domain.Repository
import org.koin.dsl.module

val dataModule = module {
    single { Endpoint() } // This is the same as `single<Endpoint> { Endpoint() }`
    single<Repository> { RepositoryImpl(endpoint = get()) }
}