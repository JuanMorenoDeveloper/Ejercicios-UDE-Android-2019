package ude.edu.uy.ejemplosharedpreferences.main.interactor

import ude.edu.uy.ejemplosharedpreferences.entity.Puntaje
import ude.edu.uy.ejemplosharedpreferences.preference.Preference
import ude.edu.uy.ejemplosharedpreferences.usecase.Generator

class BasicMainInteractor(val preference: Preference, val generator: Generator) : MainInteractor {
    override fun getLastPuntaje(): Puntaje {
        return preference.getPreferenciaByClave(Puntaje.DEFAULT_CLAVE, Puntaje.DEFAULT_VALOR)
    }

    override fun savePuntaje(puntaje: Puntaje) {
        preference.save(puntaje)
    }

    override fun nextPuntaje(): Int {
        return generator.nextValue()
    }

}