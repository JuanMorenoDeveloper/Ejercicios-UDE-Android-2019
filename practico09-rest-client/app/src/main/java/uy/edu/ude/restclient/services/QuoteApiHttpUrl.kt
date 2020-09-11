package uy.edu.ude.restclient.services

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.usecases.QuoteApi
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class QuoteApiHttpUrl(private val urlService: String) : QuoteApi {
    companion object {
        val TAG = "QuoteApiHttpUrl"
    }

    override suspend fun findQuoteById(id: String): Response =
        withContext(Dispatchers.IO) {
            val url = URL("$urlService" + "api/$id")
            val httpUrlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            httpUrlConnection.requestMethod = "GET"
            val input = BufferedReader(InputStreamReader(httpUrlConnection.inputStream))
            var inputline = input.readLine()
            val result = StringBuilder()
            while (inputline != null) {
                result.append(inputline)
                inputline = input.readLine()
            }
            Log.i(TAG, "Respuesta del servicio $result")
            jsonToResponse(result.toString())
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