package org.example.project.data.datasource

import org.koin.dsl.module
import org.slf4j.LoggerFactory

val loggingModules = module {
    single { LoggerFactory.getLogger("DatasourceLogger") }
}