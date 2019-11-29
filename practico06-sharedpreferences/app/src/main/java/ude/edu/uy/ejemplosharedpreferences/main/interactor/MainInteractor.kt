package ude.edu.uy.ejemplosharedpreferences.main.interactor

import ude.edu.uy.ejemplosharedpreferences.entity.Puntaje

interface MainInteractor {
    fun nextPuntaje(): Int
    fun getLastPuntaje(): Puntaje
    fun savePuntaje(puntaje: Puntaje)
}