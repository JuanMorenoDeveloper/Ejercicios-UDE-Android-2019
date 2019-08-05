package ude.edu.uy.ejemplosharedpreferences.entity

data class Puntaje(var clave: String = DEFAULT_CLAVE, var valor: Int = DEFAULT_VALOR) {
    companion object {
        val DEFAULT_CLAVE = "PUNTAJE"
        val DEFAULT_VALOR = 0
    }
}