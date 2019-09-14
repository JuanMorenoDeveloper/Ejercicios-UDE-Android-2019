package uy.edu.ude.restclient.main.presenter

import android.os.AsyncTask
import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.services.QuoteApiHttpUrl

class MainAsyncTask : AsyncTask<String, Void, Response>() {
    override fun doInBackground(vararg params: String?): Response {
        val quote = QuoteApiHttpUrl("http://gturnquist-quoters.cfapps.io/api")
        val response = quote.findQuoteById(2)
        return response
    }

}
