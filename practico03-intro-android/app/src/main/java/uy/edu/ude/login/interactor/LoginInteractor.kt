package uy.edu.ude.login.interactor

import uy.edu.ude.validator.LoginValidator

class LoginInteractor(val loginValidator: LoginValidator/*Casos de uso adicionales*/) {

    fun isValid(nickname: String, password: String): Boolean {
        return loginValidator.isValid(nickname, password)
    }
}
