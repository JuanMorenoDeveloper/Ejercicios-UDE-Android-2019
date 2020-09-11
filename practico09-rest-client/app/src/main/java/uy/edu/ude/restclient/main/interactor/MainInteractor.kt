package uy.edu.ude.restclient.main.interactor

import uy.edu.ude.restclient.main.presenter.Presenter
import uy.edu.ude.restclient.services.DefaultQuoteApiRetrofit

class MainInteractor: Interactor {
    override suspend fun doInBackground(presenter: Presenter, params: String) {
        val quote = DefaultQuoteApiRetrofit("http://gturnquist-quoters.cfapps.io/")
        val response = quote.findQuoteById(params)
        presenter.updateView(response)
    }
}
