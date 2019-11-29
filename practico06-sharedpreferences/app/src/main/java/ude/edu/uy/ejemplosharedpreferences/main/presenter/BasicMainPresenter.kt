package ude.edu.uy.ejemplosharedpreferences.main.presenter

import ude.edu.uy.ejemplosharedpreferences.entity.Puntaje
import ude.edu.uy.ejemplosharedpreferences.main.interactor.MainInteractor
import ude.edu.uy.ejemplosharedpreferences.main.view.PrincipalView

class BasicMainPresenter(val view: PrincipalView, val interactor: MainInteractor) : MainPresenter {
    private var puntajeActual = Puntaje()
    private var puntajeMaximo = Puntaje()

    override fun nextPuntaje() {
        puntajeActual.valor = interactor.nextPuntaje()
        interactor.savePuntaje(puntajeActual)
        showPuntaje()
    }

    override fun showPuntaje() {
        if (puntajeActual.valor > puntajeMaximo.valor) {
            puntajeMaximo.valor = puntajeActual.valor
        }
        view.showPuntajeMaximo(puntajeMaximo)
        view.showPuntajeActual(puntajeActual)
    }

    override fun showLastPuntajeMaximo() {
        puntajeMaximo = interactor.getLastPuntaje()
        view.showPuntajeMaximo(puntajeMaximo)
    }
}