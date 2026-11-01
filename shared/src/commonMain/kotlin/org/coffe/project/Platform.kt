package org.coffe.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform