package uy.edu.ude.login.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import uy.edu.ude.MainActivity
import uy.edu.ude.R
import uy.edu.ude.login.interactor.LoginInteractor
import uy.edu.ude.login.presenter.LoginPresenter
import uy.edu.ude.validator.LoginValidator

class LoginViewActivity : AppCompatActivity(), LoginView {
    var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this, LoginInteractor(LoginValidator()))
        btnLogin.setOnClickListener { doLogin() }
    }

    override fun doLogin() {
        val usuario = edUsuario.text.toString()
        val password = edPassword.text.toString()
        presenter?.doCheck(usuario, password)
    }

    override fun showOk() {
        tvResultado.text = "OK"
        val intent = Intent(
            this@LoginViewActivity,
            MainActivity::class.java
        )
        startActivity(intent)
        finish() // Cierra la activity actual
    }

    override fun showNonOk() {
        tvResultado.text = "No OK"
    }
}
