package uy.edu.ude.restclient.services

import retrofit2.Retrofit
import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.services.converter.ResponseConverterFactory
import uy.edu.ude.restclient.usecases.QuoteApi


class DefaultQuoteApiRetrofit(private val urlService: String) : QuoteApi {
    companion object {
        val TAG = "QuoteApiHttpUrl"
    }

    override fun findQuoteById(id: String): Response {
        val retrofit = Retrofit.Builder()
            .baseUrl(urlService)
            .addConverterFactory(ResponseConverterFactory())
            //.addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create<QuoteApiRetrofit>(QuoteApiRetrofit::class.java)
        return service.findQuoteById(id).execute().body()!!
    }

}