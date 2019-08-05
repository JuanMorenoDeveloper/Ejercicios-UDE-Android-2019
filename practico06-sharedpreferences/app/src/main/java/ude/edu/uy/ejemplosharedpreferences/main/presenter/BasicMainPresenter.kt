package ude.edu.uy.ejemplosharedpreferences.main.presenter

import ude.edu.uy.ejemplosharedpreferences.main.interactor.MainInteractor
import ude.edu.uy.ejemplosharedpreferences.main.view.PrincipalView

class BasicMainPresenter(val view: PrincipalView, val interactor: MainInteractor) : MainPresenter {
    private var puntajeActual: Int = 0
    private var puntajeMaximo: Int = 0
    override fun nextPuntaje() {
        puntajeActual = interactor.nextPuntaje()
    }

    override fun showPuntaje() {
        if (puntajeActual > puntajeMaximo) {
            puntajeMaximo = 0
        }
        view.showPuntajeMaximo(puntajeMaximo)
        view.showPuntajeActual(puntajeActual)
    }
}