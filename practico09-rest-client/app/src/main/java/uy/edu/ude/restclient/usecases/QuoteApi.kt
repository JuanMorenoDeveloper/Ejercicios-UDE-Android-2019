package uy.edu.ude.restclient.usecases

import uy.edu.ude.restclient.entities.Response

interface QuoteApi {
    suspend fun findQuoteById(id: String): Response
}