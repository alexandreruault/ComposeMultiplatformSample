package org.example.project.domain

import org.example.project.data.models.Planets
import org.example.project.util.Either

class Interactor(private val repository: Repository) {

    suspend fun getTatooine(): Either<Throwable, Planets> =
        try {
            Either.Right(repository.getTatooine())
        } catch (error: Throwable) {
            Either.Left(error)
        }


}