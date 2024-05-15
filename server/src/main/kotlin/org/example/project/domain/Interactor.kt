package org.example.project.domain

import org.example.project.data.models.Planets
import org.example.project.util.Either

class Interactor(private val repository: Repository) {

    suspend fun getTatooine(): Result<Planets> = runCatching {
        repository.getTatooine()
    }


    suspend fun getAlderaan(): Result<Planets> = runCatching {
        repository.getAlderaan()
    }


    suspend fun getYavin(): Result<Planets> =
        runCatching {
            repository.getYavin()
        }

}