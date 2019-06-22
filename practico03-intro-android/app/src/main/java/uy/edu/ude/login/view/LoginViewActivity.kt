package uy.edu.ude.login.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import uy.edu.ude.R
import uy.edu.ude.login.interactor.LoginInteractor
import uy.edu.ude.login.presenter.LoginPresenter
import uy.edu.ude.validator.LoginValidator

class LoginViewActivity : AppCompatActivity() {
    var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this, LoginInteractor(LoginValidator()))
        btnLogin.setOnClickListener { doLogin() }
    }

    fun doLogin() {
        val usuario = edUsuario.text.toString()
        val password = edPassword.text.toString()
        presenter?.doCheck(usuario, password)
    }

    fun showOk() {
        tvResultado.text = "OK"
    }

    fun showNonOk() {
        tvResultado.text = "No OK"
    }
}
