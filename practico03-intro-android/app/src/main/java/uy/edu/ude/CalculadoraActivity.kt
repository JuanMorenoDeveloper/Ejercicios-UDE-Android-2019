package uy.edu.ude

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculadora.*

class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        btnSuma.setOnClickListener { sumar() }
    }

    fun sumar() {
        val n1 = Integer.parseInt(edNumero1.text.toString())
        val n2 = Integer.parseInt(edNumero2.text.toString())
        val calc = Calculadora()
        tvResultado.text = "${calc.sum(n1, n2)}"
    }
}
