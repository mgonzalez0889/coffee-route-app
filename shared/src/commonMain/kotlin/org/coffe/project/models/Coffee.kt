package org.coffe.project.models

import org.jetbrains.compose.resources.DrawableResource
import kotlin.uuid.Uuid

data class HeaderDataCoffee(
    val id: Uuid = Uuid.random(),
    val titulo: String,
    val descripcion: String,
    val imagenUrl: String
)
