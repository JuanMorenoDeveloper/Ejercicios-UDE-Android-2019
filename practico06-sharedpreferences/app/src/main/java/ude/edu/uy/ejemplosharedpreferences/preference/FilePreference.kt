package ude.edu.uy.ejemplosharedpreferences.preference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import ude.edu.uy.ejemplosharedpreferences.entity.Puntaje

class FilePreference(activity: AppCompatActivity, nombre: String?, modo: Int) : Preference {

    private val sharedPreference: SharedPreferences

    init {
        sharedPreference = if (nombre == null) {
            activity.getPreferences(modo);
        } else {
            activity.getSharedPreferences(nombre, modo)
        }
    }

    override fun save(preferencia: Puntaje) {
        val editor = sharedPreference.edit()
        editor.putInt(preferencia.clave, preferencia.valor)
        editor.commit()
    }

    override fun getPreferenciaByClave(clave: String, default: Int): Puntaje {
        val valor = sharedPreference.getInt(clave, default)
        return Puntaje(clave, valor)
    }
}