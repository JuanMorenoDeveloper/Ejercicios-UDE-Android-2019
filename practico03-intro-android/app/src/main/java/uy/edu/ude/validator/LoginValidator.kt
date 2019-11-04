package uy.edu.ude.validator

import uy.edu.ude.entity.Usuario

class LoginValidator {
    val users = HashMap<String, Usuario>()

    constructor() {
        users.put("luis", Usuario("luis", "Luis C.", "Luis123"))
        users.put("maria", Usuario("maria", "Maria D.", "Maria123"))
        users.put("lucia", Usuario("lucia", "Lucia Z.", "Lucia123"))
        users.put("daniel", Usuario("daniel", "Daniel M.", "Daniel123"))
    }

    fun isValid(nickname: String, password: String): Boolean {
        val foundUser = users.get(nickname)
        if (foundUser != null) {
            if (foundUser.nickname == nickname && foundUser.password == password) {
                return true
            }
        }
        return false
    }
}
