package uy.edu.ude

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CalculadoraUnitTest {
    // Con gradle se ejecutan con
    // gradle test
    @Test
    fun givenTwoNumbers_whenSum_thenGetResult(){
        //Setup
        val calc = Calculadora()
        val n1 = 5
        val n2 = 3
        val resultExpected = 8

        //SUT
        val result = calc.sum(n1,n2)

        //Assert
        assertThat(result).isEqualTo(resultExpected)
    }

}