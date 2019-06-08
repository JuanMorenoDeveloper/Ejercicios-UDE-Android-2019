package uy.edu.ude

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener { doLogin() }
    }

    fun doLogin() {
        val usuario = edUsuario.text.toString()
        val password = edPassword.text.toString()
        tvResultado.text = doCheck(usuario, password)
    }

    fun doCheck(usuario: String, password: String): String {
        val hardcodeUser = "user"
        val hardcodePassword = "secret"
        var resultado = ""
        if (usuario == hardcodeUser && password == hardcodePassword) {
            resultado = "OK"
        } else {
            resultado = "No OK"
      }
//        val resultado =
//            if (usuario == hardcodeUser && password == hardcodePassword) {
//                "OK"
//            } else {
//                "No OK"
//            }
        return resultado
    }
}
