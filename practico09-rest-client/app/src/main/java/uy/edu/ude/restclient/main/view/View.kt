package uy.edu.ude.restclient.main.view

import uy.edu.ude.restclient.entities.Response

interface View {
    fun updateView(response: Response)
}