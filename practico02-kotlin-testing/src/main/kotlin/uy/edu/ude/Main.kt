package uy.edu.ude

import uy.edu.ude.entity.Lectura
import uy.edu.ude.entity.Lugar
import uy.edu.ude.io.ConsoleIO

fun main(args: Array<String>) {
    val lecturas = ArrayList<Lectura>()
    val lugares = ArrayList<Lugar>()
    leerLugares(lugares)
    leerLecturas(lecturas)
    consultarLugares(lugares)
    consultarLecturas(lecturas)
}

fun leerLugares(lugares: ArrayList<Lugar>) {
    var respuesta: String
    val console = ConsoleIO()
    console.showMessage("Datos de lugares\n")
    do {
        console.showMessage("ID del lugar: ")
        val id = console.readInt()
        console.showMessage("Nombre del lugar: ")
        val nombre = console.readString()
        val lugar = Lugar(id, nombre)
        lugares.add(lugar)
        console.showMessage("¿Desea agregar otro lugar? (S/N): ")
        respuesta = console.readString().toUpperCase()
    } while (respuesta == "S")
}

fun leerLecturas(lecturas: ArrayList<Lectura>) {

}

fun consultarLecturas(lecturas: ArrayList<Lectura>) {

}

fun consultarLugares(lugares: ArrayList<Lugar>) {

}