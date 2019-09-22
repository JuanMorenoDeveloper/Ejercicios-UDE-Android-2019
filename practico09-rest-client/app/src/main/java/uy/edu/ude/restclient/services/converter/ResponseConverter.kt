package uy.edu.ude.restclient.services.converter

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Converter
import uy.edu.ude.restclient.entities.Response

class ResponseConverter : Converter<ResponseBody, Response> {

    override fun convert(value: ResponseBody): Response {
        val json = JSONObject(value.string())
        val type = json.getString("type")
        val value = json.getJSONObject("value")
        val id = value.getInt("id")
        val quote = value.getString("quote")
        return Response(type, id, quote)
    }
}