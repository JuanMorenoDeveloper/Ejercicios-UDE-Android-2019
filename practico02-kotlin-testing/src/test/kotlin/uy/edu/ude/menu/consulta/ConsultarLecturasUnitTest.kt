package uy.edu.ude.menu.consulta

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import uy.edu.ude.entity.Lectura

class ConsultarLecturasUnitTest {

    @Test
    fun givenLecturas_whenFindById_thenFoundLectura() {
        val idExpected = 1
        val tempExpected = 25.4
        val lecturas = arrayListOf(Lectura(idExpected, tempExpected), Lectura(2, 35.3))
        val consultar = ConsultarLecturas(lecturas)

        val lecturaFound = consultar.findById(1)

        assertThat(lecturaFound?.id).isEqualTo(idExpected)
    }

    @Test
    fun givenInvalidId_whenFindById_thenFoundNull() {
        val idExpected = 5
        val tempExpected = 25.4
        val lecturas = arrayListOf(Lectura(idExpected, tempExpected), Lectura(2, 35.3))
        val consultar = ConsultarLecturas(lecturas)

        val lecturaFound = consultar.findById(1)

        assertThat(lecturaFound?.id).isNull()
    }
}