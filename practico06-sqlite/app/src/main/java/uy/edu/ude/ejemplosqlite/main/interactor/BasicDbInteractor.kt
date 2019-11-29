package uy.edu.ude.ejemplosqlite.main.interactor

import uy.edu.ude.ejemplosqlite.entity.Usuario
import uy.edu.ude.ejemplosqlite.repository.UsuarioRepository

class BasicDbInteractor(private val usuarioRepository: UsuarioRepository) : DbInteractor {
    override fun save(usuario: Usuario): String {
        val usuarioFound = usuarioRepository.findById(usuario.id)
        return if (usuarioFound == null) {
            usuarioRepository.save(usuario)
            "Insert OK"
        } else {
            "Usuario ya existe"
        }
    }

    override fun update(usuario: Usuario): String {
        usuarioRepository.update(usuario)
        return "Update OK"
    }

    override fun findById(id: Int): String {
        val usuario = usuarioRepository.findById(id)
        return usuario?.toString() ?: "Usuario no encontrado"
    }

    override fun findAll(): String {
        val usuarios = usuarioRepository.findAll()
        return if (usuarios.isEmpty()) {
            "Consulta sin resultados"
        } else {
            val result = StringBuffer()
            usuarios.forEach({ result.append("$it \n") })
            result.toString()
        }
    }

    override fun deleteById(id: Int): String {
        usuarioRepository.deleteById(id)
        return "Delete OK"
    }
}