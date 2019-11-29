package uy.edu.ude.ejemplosqlite.repository

import uy.edu.ude.ejemplosqlite.entity.Usuario

interface UsuarioRepository {
    fun save(usuario: Usuario)
    fun update(usuario: Usuario)
    fun findById(id: Int): Usuario?
    fun findAll(): List<Usuario>
    fun deleteById(id: Int)
}
