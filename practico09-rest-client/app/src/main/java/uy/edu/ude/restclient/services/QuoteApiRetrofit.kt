package uy.edu.ude.restclient.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import uy.edu.ude.restclient.entities.Response

interface QuoteApiRetrofit {
    @GET("api/{id}")
    fun findQuoteById(@Path("id") id: String): Call<Response>
}