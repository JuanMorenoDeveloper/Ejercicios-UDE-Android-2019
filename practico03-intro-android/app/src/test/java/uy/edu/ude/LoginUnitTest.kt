package uy.edu.ude

import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test

class LoginUnitTest {

    @Test
    fun givenValidUser_whenDoLogin_thenGetOk() {
        val usuario = "user"
        val password = "secret"
        val resultadoExpected = "OK"
        val login = LoginActivity()

        val resultado = login.doCheck(usuario,password)

        assertThat(resultado).isEqualTo(resultadoExpected)
    }

    @Test
    fun givenInvalidUser_whenDoLogin_thenGetNoOk() {
        val usuario = "user"
        val password = "secreto"
        val resultadoExpected = "No OK"
        val login = LoginActivity()

        val resultado = login.doCheck(usuario,password)

        assertThat(resultado).isEqualTo(resultadoExpected)
    }
}
