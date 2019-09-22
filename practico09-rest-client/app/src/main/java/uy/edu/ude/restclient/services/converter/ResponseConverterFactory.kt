package uy.edu.ude.restclient.services.converter

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import uy.edu.ude.restclient.entities.Response
import java.lang.reflect.Type

class ResponseConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, Response>? {
        return ResponseConverter()
    }
}