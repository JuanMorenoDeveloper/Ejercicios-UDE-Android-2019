package uy.edu.ude.restclient.services

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.usecases.QuoteApi
import java.net.URL


class QuoteApiOkHttp(private val urlService: String) : QuoteApi {
    companion object {
        val TAG = "QuoteApiHttpUrl"
    }

    override suspend fun findQuoteById(id: String): Response =
        withContext(Dispatchers.IO) {
            val url = URL("$urlService" + "api/$id")
            val client = OkHttpClient()
            val request: Request
            val response: okhttp3.Response
            client.run {
                request = Request.Builder()
                    .url(url)
                    .build()
                response = client.newCall(request).execute()
            }
            //El response.body solo se puede llamar una vez, luego cierra el buffer
            val body = response.body()!!.string()
            Log.i(TAG, "Respuesta del servicio ${body}")
            jsonToResponse(body)
        }

    private fun jsonToResponse(input: String): Response {
        val json = JSONObject(input)
        val type = json.getString("type")
        val value = json.getJSONObject("value")
        val id = value.getInt("id")
        val quote = value.getString("quote")
        return Response(type, id, quote)
    }
}