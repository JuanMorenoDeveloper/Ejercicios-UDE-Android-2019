package ude.edu.uy.ejemplosharedpreferences.preference

import ude.edu.uy.ejemplosharedpreferences.entity.Puntaje

interface Preference {
    fun save(preferencia: Puntaje)
    fun getPreferenciaByClave(clave: String, default: Int): Puntaje
}