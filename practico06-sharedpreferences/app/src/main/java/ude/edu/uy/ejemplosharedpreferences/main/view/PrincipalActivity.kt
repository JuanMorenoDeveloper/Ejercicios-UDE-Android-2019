package ude.edu.uy.ejemplosharedpreferences.main.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_principal.*
import ude.edu.uy.ejemplosharedpreferences.R
import ude.edu.uy.ejemplosharedpreferences.entity.Puntaje
import ude.edu.uy.ejemplosharedpreferences.main.interactor.BasicMainInteractor
import ude.edu.uy.ejemplosharedpreferences.main.presenter.BasicMainPresenter
import ude.edu.uy.ejemplosharedpreferences.main.presenter.MainPresenter
import ude.edu.uy.ejemplosharedpreferences.preference.FilePreference
import ude.edu.uy.ejemplosharedpreferences.usecase.RandomGenerator

class PrincipalActivity : AppCompatActivity(), PrincipalView {
    private lateinit var presenter: MainPresenter

    companion object {
        private val CUSTOM_PREFERENCES = "customPreferences"
        private val MAX_PUNTAJE = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        val preference = FilePreference(this, CUSTOM_PREFERENCES, Context.MODE_PRIVATE)
        val generator = RandomGenerator(MAX_PUNTAJE)
        val interactor = BasicMainInteractor(preference, generator)
        presenter = BasicMainPresenter(this, interactor)
        btnGenerarPuntaje.setOnClickListener({ generarPuntaje() })
        presenter.showLastPuntajeMaximo()
    }

    override fun generarPuntaje() {
        presenter.nextPuntaje()
    }

    override fun showPuntajeMaximo(puntaje: Puntaje) {
        tvPuntajeMaximo.text = puntaje.valor.toString()
    }

    override fun showLastPuntajeMaximo() {
        presenter.showLastPuntajeMaximo()
    }

    override fun showPuntajeActual(puntaje: Puntaje) {
        tvPuntaje.text = puntaje.valor.toString()
    }

}
