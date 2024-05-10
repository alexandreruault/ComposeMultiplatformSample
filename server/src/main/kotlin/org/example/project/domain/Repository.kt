package org.example.project.domain

import org.example.project.data.models.Planets
import org.example.project.util.Either

interface Repository {

    suspend fun getTatooine(): Planets

}
