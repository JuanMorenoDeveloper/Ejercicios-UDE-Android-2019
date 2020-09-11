package uy.edu.ude.restclient.services

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.services.converter.ResponseConverterFactory
import uy.edu.ude.restclient.usecases.QuoteApi


class DefaultQuoteApiRetrofit(private val urlService: String) : QuoteApi {
    companion object {
        val TAG = "QuoteApiHttpUrl"
    }

    override suspend fun findQuoteById(id: String): Response =
        withContext(Dispatchers.IO) {
            val retrofit = Retrofit.Builder()
                .baseUrl(urlService)
                .addConverterFactory(ResponseConverterFactory())
                //.addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create<QuoteApiRetrofit>(QuoteApiRetrofit::class.java)
            service.findQuoteById(id).execute().body()!!
        }

}