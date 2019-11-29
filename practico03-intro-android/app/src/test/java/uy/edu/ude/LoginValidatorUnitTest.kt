package uy.edu.ude

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import uy.edu.ude.validator.LoginValidator

class LoginValidatorUnitTest {

    @Test
    fun givenValidUser_whenIsValid_thenReturnsTrue() {
        //Arrange
        val validator = LoginValidator()
        val nickname = "luis"
        val password = "Luis123"

        val isValid = validator.isValid(nickname, password)

        assertThat(isValid).isTrue()
    }

    @Test
    fun givenInvalidUser_whenIsValid_thenReturnsFalse() {
        //Arrange
        val validator = LoginValidator()
        val nickname = "luis"
        val password = "Luis124"

        val isValid = validator.isValid(nickname, password)

        assertThat(isValid).isFalse()
    }

}