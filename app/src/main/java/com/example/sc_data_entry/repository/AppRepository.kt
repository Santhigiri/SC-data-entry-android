package com.example.sc_data_entry.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.repository.DateResponse

class AppRepository {
    private val client = HttpClient(CIO){
        install(ContentNegotiation){
            json(
                Json{
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }
    }
    val baseUrl: String = "http://10.0.0.151:5000"
    suspend fun getDateResponse() : DateResponse{
        val subUrl: String = "/date/v1"
        val response = client.get(baseUrl + subUrl).body<DateResponse>()
        println(response.toString())
        return response

    }

}