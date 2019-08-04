package ude.edu.uy.ejemplosharedpreferences.main.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_principal.*
import ude.edu.uy.ejemplosharedpreferences.R
import java.util.*

class PrincipalActivity : AppCompatActivity() {

  private lateinit var sharedPreferences: SharedPreferences
  private lateinit var preferences: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_principal)
    sharedPreferences = getPreferences(Context.MODE_PRIVATE)
    preferences = getSharedPreferences(CUSTOM_PREFERENCES, Context.MODE_PRIVATE)
    Log.d("PrincipalActivity", "onCreate: " + preferences.getBoolean("test", false))
    tvPuntajeMaximo.text = sharedPreferences.getInt(PUNTAJE, 0).toString()
    btnGenerarPuntaje.setOnClickListener {
      val random = Random()
      val valor = random.nextInt(1000)
      val valMax = sharedPreferences.getInt(PUNTAJE, 0)
      tvPuntaje.text = valor.toString()
      sharedPreferences = getPreferences(Context.MODE_PRIVATE)
      if (valor > valMax) {
        tvPuntajeMaximo.text = valor.toString()
        val editor = sharedPreferences.edit()
        editor.putInt(PUNTAJE, valor)
        editor.commit()
      }
      /*TODO 1*/
      val editor = preferences.edit()
      editor.putBoolean("test", true)
      editor.commit()
    }
  }

  fun findPreferenciaByName(activity: AppCompatActivity, propiedadABuscar: String): Boolean {
    sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE)
    val encontro = sharedPreferences.getString(propiedadABuscar, "NO_EXISTE")
    return encontro == "NO_EXISTE"
  }

  companion object {
    private val PUNTAJE = "PUNTAJE"
    private val CUSTOM_PREFERENCES = "customPreferences"
  }
}
