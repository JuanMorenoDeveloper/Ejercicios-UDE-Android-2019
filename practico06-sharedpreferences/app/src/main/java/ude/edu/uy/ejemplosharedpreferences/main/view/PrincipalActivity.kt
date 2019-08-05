package ude.edu.uy.ejemplosharedpreferences.main.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_principal.*
import ude.edu.uy.ejemplosharedpreferences.R
import ude.edu.uy.ejemplosharedpreferences.main.interactor.BasicMainInteractor
import ude.edu.uy.ejemplosharedpreferences.main.presenter.BasicMainPresenter
import ude.edu.uy.ejemplosharedpreferences.main.presenter.MainPresenter
import ude.edu.uy.ejemplosharedpreferences.preference.FilePreference

class PrincipalActivity : AppCompatActivity(), PrincipalView {

    private lateinit var presenter: MainPresenter

    companion object {
        private val PUNTAJE = "PUNTAJE"
        private val CUSTOM_PREFERENCES = "customPreferences"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        val interactor = BasicMainInteractor(FilePreference(this, CUSTOM_PREFERENCES, Context.MODE_PRIVATE))
        presenter = BasicMainPresenter(this, interactor)
        btnGenerarPuntaje.setOnClickListener({ generarPuntaje() })
//
//    sharedPreferences = getPreferences(Context.MODE_PRIVATE)
//    preferences = getSharedPreferences(CUSTOM_PREFERENCES, Context.MODE_PRIVATE)
//    Log.d("PrincipalActivity", "onCreate: " + preferences.getBoolean("test", false))
//    tvPuntajeMaximo.text = sharedPreferences.getInt(PUNTAJE, 0).toString()
//    btnGenerarPuntaje.setOnClickListener {
//      val random = Random()
//      val valor = random.nextInt(1000)
//      val valMax = sharedPreferences.getInt(PUNTAJE, 0)
//      tvPuntaje.text = valor.toString()
//      sharedPreferences = getPreferences(Context.MODE_PRIVATE)
//      if (valor > valMax) {
//        tvPuntajeMaximo.text = valor.toString()
//        val editor = sharedPreferences.edit()
//        editor.putInt(PUNTAJE, valor)
//        editor.commit()
//      }
//      /*TODO 1*/
//      val editor = preferences.edit()
//      editor.putBoolean("test", true)
//      editor.commit()
//    }
    }

    override fun generarPuntaje() {
        presenter.nextValue()
    }

    override fun showPuntajeMaximo(puntaje: Int) {
        tvPuntajeMaximo.text = puntaje.toString()
    }

    override fun showPuntajeActual(puntaje: Int) {
        tvPuntaje.text = puntaje.toString()
    }

}
