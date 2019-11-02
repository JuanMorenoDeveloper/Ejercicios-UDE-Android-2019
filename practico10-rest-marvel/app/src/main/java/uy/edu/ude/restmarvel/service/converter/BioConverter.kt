package uy.edu.ude.restclient.services.converter

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Converter
import uy.edu.ude.restmarvel.entity.Bio

class BioConverter : Converter<ResponseBody, Bio> {

    override fun convert(body: ResponseBody): Bio {
        return convert(body.string())
    }

    fun convert(input: String): Bio {
        val root = JSONObject(input)
        val data = root.getJSONObject("data")
        val results = data.getJSONArray("results")
        val details = results.getJSONObject(0)
        val id = details.getInt("id")
        val name = details.getString("name")
        val description = details.getString("description")
        val comics = details.getJSONObject("comics")
        val comicsAvailables = comics.getInt("available")
        return Bio(id, name, description, comicsAvailables)
    }
}