package uy.edu.ude.io

import org.assertj.core.api.Assertions.assertThat
import org.junit.AfterClass
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ConsoleIOUnitTest {

    @Test
    fun givenText_whenPrint_thenPrintText() {
        val expectedTest = "Hello from Kotlin"
        val out = ByteArrayOutputStream()
        System.setOut(PrintStream(out))
        val console = ConsoleIO()

        console.showMessage(expectedTest)
        out.flush()
        val printedText = String(out.toByteArray())

        assertThat(printedText).isEqualTo(expectedTest)
    }

    @Test
    fun givenInput_whenRead_thenReadInt() {
        val expectedInt = "45"
        val input = ByteArrayInputStream(expectedInt.toByteArray())
        System.setIn(input)
        val console = ConsoleIO()

        val readInt = console.readInt()

        assertThat(readInt).isEqualTo(expectedInt.toInt())
    }

    companion object {
        @AfterClass
        fun resetIO() {
            System.setOut(System.out)
            System.setIn(System.`in`)
        }
    }
}