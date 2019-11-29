package uy.edu.ude.ejemplosqlite.entity

data class Usuario(val id: Int, val nombre: String) {
    companion object {
        val DEFAULT = Usuario(0, "")
    }
}