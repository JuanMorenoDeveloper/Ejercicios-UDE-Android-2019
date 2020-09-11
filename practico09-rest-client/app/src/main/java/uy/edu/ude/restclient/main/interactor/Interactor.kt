package uy.edu.ude.restclient.main.interactor

import uy.edu.ude.restclient.main.presenter.Presenter

interface Interactor {
    suspend fun doInBackground(presenter: Presenter, params: String)
}