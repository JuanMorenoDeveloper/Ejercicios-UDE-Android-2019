package uy.edu.ude.restclient.main.presenter

import uy.edu.ude.restclient.entities.Response

interface Presenter {
    suspend fun findQuoteByRandom()
    fun updateView(response: Response)
    fun onDestroy()
}