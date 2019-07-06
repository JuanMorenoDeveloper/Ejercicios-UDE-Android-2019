package ude.edu.uy.ejemplosharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_principal.*
import java.util.*

class PrincipalActivity : AppCompatActivity() {

  private var sharedPreferences: SharedPreferences? = null
  private var preferences: SharedPreferences? = null
  /**/
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    sharedPreferences = getPreferences(Context.MODE_PRIVATE)
    preferences = getSharedPreferences(CUSTOM_PREFERENCES, Context.MODE_PRIVATE)
    Log.d("PrincipalActivity", "onCreate: " + preferences!!.getBoolean("test", false))
    setContentView(R.layout.activity_principal)
    tvPuntajeMaximo.text = sharedPreferences!!.getInt(PUNTAJE, 0).toString()
    btnGenerarPuntaje!!.setOnClickListener {
      val random = Random()
      val valor = random.nextInt(1000)
      val valMax = sharedPreferences!!.getInt(PUNTAJE, 0)
      tvPuntaje.text = valor.toString()
      if (valor > valMax) {
        tvPuntajeMaximo.text = valor.toString()
        val editor = sharedPreferences!!.edit()
        editor.putInt(PUNTAJE, valor)
        editor.commit()
      }
      val editor = preferences!!.edit()
      editor.putBoolean("test", true)
      editor.commit()
    }
  }

  fun findPreferenciaByName(activity: AppCompatActivity, propiedadABuscar: String): Boolean {
    sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE)
    val encontro = sharedPreferences!!.getString(propiedadABuscar, "NO_EXISTE")
    return encontro == "NO_EXISTE"
  }

  companion object {
    private val PUNTAJE = "PUNTAJE"
    private val CUSTOM_PREFERENCES = "customPreferences"
  }
}
