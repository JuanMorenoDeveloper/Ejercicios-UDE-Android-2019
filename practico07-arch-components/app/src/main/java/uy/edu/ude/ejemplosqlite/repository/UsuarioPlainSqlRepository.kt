package uy.edu.ude.ejemplosqlite.repository

import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import uy.edu.ude.ejemplosqlite.entity.Usuario

class UsuarioPlainSqlRepository(val dbHelper: SQLiteOpenHelper) : UsuarioRepository {
    private val TAG: String = "PlainSqlRepository"

    override fun save(usuario: Usuario) {
        Log.i(TAG, "Insertando datos con execSQL")
        val db = dbHelper.writableDatabase
        val sql = "insert into usuario (id,nombre) values (${usuario.id},'${usuario.nombre}')"
        Log.i(TAG, "Ejecutando consulta: $sql")
        db.execSQL(sql)
        db.close()
    }

    override fun update(usuario: Usuario) {
        Log.i(TAG, "Actualizando datos")
        val db = dbHelper.writableDatabase
        val sql = "update usuario set nombre ='${usuario.nombre}' where id=${usuario.id}"
        Log.i(TAG, "Ejecutando consulta: $sql")
        db.execSQL(sql)
        db.close()
    }

    override fun findAll(): List<Usuario> {
        Log.i(TAG, "Buscando datos")
        val db = dbHelper.readableDatabase
        val sql = "select id,nombre from usuario"
        val cursor = db.rawQuery(sql, null)
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
        val sql = "select id,nombre from usuario where id=$id"
        val cursor = db.rawQuery(sql, null)
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
        Log.i(TAG, "Borrando datos")
        val db = dbHelper.writableDatabase
        val sql = "delete from usuario where id=$id"
        Log.i(TAG, "Ejecutando consulta: $sql")
        db.execSQL(sql)
        db.close()
    }

}
