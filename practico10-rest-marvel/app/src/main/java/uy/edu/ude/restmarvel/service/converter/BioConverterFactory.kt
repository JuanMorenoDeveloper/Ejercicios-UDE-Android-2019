package uy.edu.ude.restclient.services.converter

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import uy.edu.ude.restmarvel.entity.Bio
import java.lang.reflect.Type

class BioConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, Bio>? {
        return BioConverter()
    }
}