package uy.edu.ude.restclient.usecases

import uy.edu.ude.restclient.entities.Response

interface QuoteApi {
    fun findQuoteById(id: Number): Response
    fun findQuoteByRandom(): Response
}