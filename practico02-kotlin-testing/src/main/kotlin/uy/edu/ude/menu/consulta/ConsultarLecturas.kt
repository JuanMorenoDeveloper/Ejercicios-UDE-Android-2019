package uy.edu.ude.menu.consulta

import uy.edu.ude.entity.Lectura

class ConsultarLecturas(val lecturas: ArrayList<Lectura>) {

    fun findById(id: Int): Lectura? {
//        for (lectura in lecturas) {
//            if (lectura.id == id) {
//                return lectura
//            }
//        }
//        return null
        return lecturas.find { it.id == id }
    }
}