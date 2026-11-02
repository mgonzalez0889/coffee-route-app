package org.coffe.project.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic


val navigationModule = SerializersModule {
    polymorphic(NavKey::class) {
        subclass(Home::class, Home.serializer())
        subclass(Historia::class, Historia.serializer())
        subclass(Sitios::class, Sitios.serializer())
    }
}

val savedJson = Json {
    serializersModule = navigationModule
    ignoreUnknownKeys = true
}