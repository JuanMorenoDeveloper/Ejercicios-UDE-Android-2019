package uy.edu.ude.restclient.main.presenter

import android.os.AsyncTask
import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.services.DefaultQuoteApiRetrofit

class MainAsyncTask(val presenter: Presenter) : AsyncTask<String, Void, Response>() {
    override fun doInBackground(vararg params: String): Response {
        val quote = DefaultQuoteApiRetrofit("http://gturnquist-quoters.cfapps.io/")
        val response = quote.findQuoteById(params[0])
        return response
    }

    override fun onPostExecute(result: Response) {
        presenter.updateView(result)
    }

}
