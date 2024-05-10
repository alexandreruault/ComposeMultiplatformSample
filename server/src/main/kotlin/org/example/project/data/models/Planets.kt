package org.example.project.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Planets(
    val climate: String,
    val diameter: String,
    val gravity: String,
    val name: String,
    val population: String,
)