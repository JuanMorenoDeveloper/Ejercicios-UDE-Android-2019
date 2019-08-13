package uy.edu.ude.ejemplosqlite.repository

import android.content.ContentValues
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import uy.edu.ude.ejemplosqlite.entity.Usuario

class UsuarioWithMethodRepository(val dbHelper: SQLiteOpenHelper) : UsuarioRepository {
    private val TAG: String = "WithMethodRepository"

    override fun save(usuario: Usuario) {
        Log.i(TAG, "Insertando datos insert()")
        val db = dbHelper.writableDatabase
        val registro = ContentValues()
        registro.put("id", usuario.id)
        registro.put("nombre", usuario.nombre)
        db.insert("usuario", null, registro)
        db.close()
    }

    override fun update(usuario: Usuario) {
        Log.i(TAG, "Actualizando datos con update()")
        val db = dbHelper.writableDatabase
        val registro = ContentValues()
        registro.put("id", usuario.id)
        registro.put("nombre", usuario.nombre)
        db.update("usuario", registro, "id=${usuario.id}", null)
        db.close()
    }

    override fun findAll(): List<Usuario> {
        Log.i(TAG, "Buscando datos")
        val db = dbHelper.readableDatabase
        val columnas = arrayOf("id", "nombre")
        val cursor = db.query("usuario", columnas, null, null, null, null, null)
        val resultados = ArrayList<Usuario>()
        if (cursor.moveToFirst()) {
            do {
                val idFound = cursor.getInt(0)
                val nameFound = cursor.getString(1)
                resultados.add(Usuario(idFound, nameFound))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return resultados
    }

    override fun findById(id: Int): Usuario? {
        Log.i(TAG, "Buscando datos")
        val db = dbHelper.readableDatabase
        val columnas = arrayOf("id", "nombre")
        val cursor = db.query("usuario", columnas, "id=$id", null, null, null, null)
        val resultado: Usuario?
        if (cursor.moveToFirst()) {
            val idFound = cursor.getInt(0)
            val nameFound = cursor.getString(1)
            resultado = Usuario(idFound, nameFound)
        } else {
            resultado = null
        }
        cursor.close()
        db.close()
        return resultado
    }

    override fun deleteById(id: Int) {
        Log.i(TAG, "Borrando datos con delete()")
        val db = dbHelper.writableDatabase
        db.delete("usuario", "id=$id", null)
        db.close()
    }

}
