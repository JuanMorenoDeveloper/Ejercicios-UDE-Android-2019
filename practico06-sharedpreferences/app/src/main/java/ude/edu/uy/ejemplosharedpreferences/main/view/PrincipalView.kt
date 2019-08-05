package ude.edu.uy.ejemplosharedpreferences.main.view

import ude.edu.uy.ejemplosharedpreferences.entity.Puntaje

interface PrincipalView {
    fun generarPuntaje()
    fun showPuntajeMaximo(puntaje: Puntaje)
    fun showPuntajeActual(puntaje: Puntaje)
    fun showLastPuntajeMaximo()
}