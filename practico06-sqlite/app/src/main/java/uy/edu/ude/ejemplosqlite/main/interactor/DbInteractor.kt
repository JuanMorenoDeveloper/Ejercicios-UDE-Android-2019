package uy.edu.ude.ejemplosqlite.main.interactor

import uy.edu.ude.ejemplosqlite.entity.Usuario

interface DbInteractor {
    fun save(usuario: Usuario): String
    fun update(usuario: Usuario): String
    fun findById(id: Int): String
    fun findAll(): String
    fun deleteById(id: Int): String
}