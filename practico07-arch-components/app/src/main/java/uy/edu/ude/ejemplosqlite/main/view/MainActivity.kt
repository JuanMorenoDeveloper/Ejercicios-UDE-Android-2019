package uy.edu.ude.ejemplosqlite.main.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import uy.edu.ude.ejemplosqlite.R
import uy.edu.ude.ejemplosqlite.entity.Command
import uy.edu.ude.ejemplosqlite.entity.Command.*
import uy.edu.ude.ejemplosqlite.entity.Usuario
import uy.edu.ude.ejemplosqlite.main.interactor.BasicDbInteractor
import uy.edu.ude.ejemplosqlite.main.interactor.DbInteractor
import uy.edu.ude.ejemplosqlite.main.presenter.BasicMainPresenter
import uy.edu.ude.ejemplosqlite.main.presenter.MainPresenter
import uy.edu.ude.ejemplosqlite.persistence.DbHelper
import uy.edu.ude.ejemplosqlite.repository.UsuarioRepository
import uy.edu.ude.ejemplosqlite.repository.UsuarioWithMethodRepository

class MainActivity : AppCompatActivity(), MainView {

    private val TAG = "MainActivity"
    private val nombreBD = "BDUsuario"
    private lateinit var dbHelper: DbHelper
    private lateinit var mainPresenter: MainPresenter
    private lateinit var dbInteractor: DbInteractor
    private lateinit var usuarioRepository: UsuarioRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "Iniciando la aplicacion")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnInsert.setOnClickListener { sendCommand(currentUser(), INSERT) }
        btnSearch.setOnClickListener({ sendCommand(currentUser(), SEARCH) })
        btnUpdate.setOnClickListener({ sendCommand(currentUser(), UPDATE) })
        btnDelete.setOnClickListener({ sendCommand(currentUser(), DELETE) })
        Log.i(TAG, "Iniciando la BD")
        dbHelper = DbHelper(this, nombreBD, null, 1)
        //usuarioRepository = UsuarioPlainSqlRepository(dbHelper)
        usuarioRepository = UsuarioWithMethodRepository(dbHelper)
        dbInteractor = BasicDbInteractor(usuarioRepository)
        mainPresenter = BasicMainPresenter(this, dbInteractor)
    }

    private fun currentUser(): Usuario {
        val id = etId.text.toString().toIntOrNull();
        return if (id != null) {
            Usuario(id, etName.text.toString())
        } else {
            Usuario.DEFAULT
        }
    }

    override fun sendCommand(usuario: Usuario, command: Command) {
        Log.i(TAG, "Ejecutando commando")
        if (command == SEARCH && usuario == Usuario.DEFAULT) {
            mainPresenter.sendCommand(Usuario.DEFAULT, SEARCH_ALL)
        } else {
            mainPresenter.sendCommand(usuario, command)
        }
    }

    override fun showResults(results: String) {
        tvResults.text = "Los resultados son: \n$results"
        Log.i(TAG, "Operación completada")
    }

    override fun onDestroy() {
        Log.i(TAG, "Cerrando BD")
        dbHelper.close()
        super.onDestroy()
    }
}
