package uy.edu.ude.ejemplosqlite.main.view

import uy.edu.ude.ejemplosqlite.entity.Command
import uy.edu.ude.ejemplosqlite.entity.Usuario

interface MainView {
    fun sendCommand(usuario: Usuario, command: Command)
    fun showResults(results: String)
}