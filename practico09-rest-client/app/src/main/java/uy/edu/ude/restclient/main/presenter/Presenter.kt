package uy.edu.ude.restclient.main.presenter

import uy.edu.ude.restclient.entities.Response

interface Presenter {
    fun findQuoteByRandom()
    fun updateView(response: Response)
    fun onDestroy()
}