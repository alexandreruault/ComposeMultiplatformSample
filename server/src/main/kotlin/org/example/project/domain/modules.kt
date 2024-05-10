package org.example.project.domain

import org.koin.dsl.module

val domainModules = module {
    single { Interactor(repository = get()) }
}