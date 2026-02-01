package org.example.programacion2.network.model

import androidx.compose.ui.autofill.ContentType
import io.ktor.client.HttpClient
import io.ktor.http.ContentType.Application.Json

object  NetworkUtils {
    val httpClient = HttpClient {
        install(ContentNavigation) {
            json(
                json = Json {
                    ignoreUnkownKeys = true
                },
                contentType = ContentType.Any
            )
        }
    }
}