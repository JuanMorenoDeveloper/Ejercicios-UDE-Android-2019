package uy.edu.ude

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnHello.setOnClickListener { processInput() }
    }

    private fun processInput() {
        val input = edText.text.toString()
        if (input.length <= 6) {
            tvHello.text = "Hola $input"
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
        } else {
            edText.error = "Entrada incorrecta"
        }
    }
}
