package uy.edu.ude.restclient.main.presenter


import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.main.interactor.Interactor
import uy.edu.ude.restclient.main.view.View

class MainPresenter(var view: View?, val interactor: Interactor) : Presenter {

    override suspend fun findQuoteByRandom() {
        interactor.doInBackground(this, "random")
    }

    override fun updateView(response: Response) {
        view?.updateView(response)
    }

    override fun onDestroy() {
        view = null
    }

}