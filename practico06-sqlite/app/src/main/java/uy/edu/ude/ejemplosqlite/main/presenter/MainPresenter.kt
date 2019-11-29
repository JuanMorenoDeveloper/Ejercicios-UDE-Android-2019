package uy.edu.ude.ejemplosqlite.main.presenter

import uy.edu.ude.ejemplosqlite.entity.Command
import uy.edu.ude.ejemplosqlite.entity.Usuario

interface MainPresenter {
    fun sendCommand(usuario: Usuario, command: Command)
    fun showResults(results: String)
}