package uy.edu.ude.restclient.main.presenter


import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.main.view.View

class MainPresenter(var view: View?) : Presenter {

    override fun findQuoteByRandom() {
        MainAsyncTask(this).execute("random")
    }

    override fun updateView(response: Response) {
        view?.updateView(response)
    }

    override fun onDestroy() {
        view = null
    }

}