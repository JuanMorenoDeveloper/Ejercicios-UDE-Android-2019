package uy.edu.ude.login.presenter

import uy.edu.ude.login.interactor.LoginInteractor
import uy.edu.ude.login.view.LoginViewActivity

class LoginPresenter(
    var view: LoginViewActivity,
    var interactor: LoginInteractor
) {
    fun doCheck(usuario: String, password: String) {
        val isValid = interactor.isValid(usuario, password)
        if (isValid) {
            view.showOk()
        } else {
            view.showNonOk()
        }
    }
}