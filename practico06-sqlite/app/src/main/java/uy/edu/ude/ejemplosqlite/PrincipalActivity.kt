package uy.edu.ude.ejemplosqlite

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class PrincipalActivity : AppCompatActivity(), View.OnClickListener {

  private val TAG = "PrincipalActivity"
  private val nombreBD = "BDUsuario"
  private var bdHelper: BdHelper? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    Log.i(TAG, "Iniciando la aplicacion")
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    btnInsert!!.setOnClickListener(this)
    btnSearch!!.setOnClickListener(this)
    btnUpdate!!.setOnClickListener(this)
    btnDelete!!.setOnClickListener(this)
    Log.i(TAG, "Iniciando la BD")
    bdHelper = BdHelper(this, nombreBD, null, 1)
  }

  override fun onClick(v: View) {
    Log.i(TAG, "Ejecutando click")
    try {
      Log.i(TAG, "Leyendo datos")
      var id = 0
      var nombre = ""
      if (v.id != R.id.btnSearch) {
        id = Integer.parseInt(etId!!.text.toString())
        nombre = etName!!.text.toString()
      }
      when (v.id) {
        R.id.btnInsert -> {
          //insertSql(id, nombre);
          insertWithMethod(id, nombre)
          tvResults.text = "Insert OK"
        }
        R.id.btnSearch -> {
          val resultado = searchWithMethod()//searchRawSql();
          tvResults.text = "Los resultados son: \n$resultado"
        }
        R.id.btnUpdate -> {
          //updateSql(id, nombre);
          updateWithMethod(id, nombre)
          tvResults.text = "Update OK"
        }
        R.id.btnDelete -> {
          //deleteSql(id);
          deleteWithMethod(id)
          tvResults.text = "Delete OK"
        }
      }
    } catch (e: NumberFormatException) {
      Log.e(TAG, "Error en operacion de conversion", e)
      Toast.makeText(this, "Ocurrio un error al convertir datos", Toast.LENGTH_SHORT).show()
    }

    Log.i(TAG, "Operación completada")
  }

  @Throws(NumberFormatException::class)
  fun insertSql(id: Int, nombre: String) {
    Log.i(TAG, "Insertando datos con execSQL")
    val db = bdHelper!!.writableDatabase
    val sql = "insert into usuario (id,nombre) values ($id,'$nombre')"
    Log.i(TAG, "Ejecutando consulta: $sql")
    db.execSQL(sql)
    db.close()
  }

  @Throws(NumberFormatException::class)
  fun insertWithMethod(id: Int, nombre: String) {
    Log.i(TAG, "Insertando datos insert()")
    val db = bdHelper!!.writableDatabase
    val registro = ContentValues()
    registro.put("id", id)
    registro.put("nombre", nombre)
    db.insert("usuario", null, registro)
    db.close()
  }

  @Throws(NumberFormatException::class)
  fun searchRawSql(): String {
    Log.i(TAG, "Buscando datos")
    val db = bdHelper!!.readableDatabase
    //"select * from usuario where id="+id
    val sql = "select * from usuario"
    val cursor = db.rawQuery(sql, null)
    var resultados = ""
    if (cursor.moveToFirst()) {
      do {
        val idFound = cursor.getInt(0)
        val nameFound = cursor.getString(1)
        resultados += "id: $idFound, Nombre: $nameFound\n"
      } while (cursor.moveToNext())
    }
    cursor.close()
    db.close()
    return resultados
  }

  /**/
  @Throws(NumberFormatException::class)
  fun searchWithMethod(): String {
    Log.i(TAG, "Buscando datos")
    val db = bdHelper!!.readableDatabase
    val columnas = arrayOf("id", "nombre")
    val cursor = db.query("usuario", columnas, null, null, null, null, null)
    var resultados = ""
    if (cursor.moveToFirst()) {
      do {
        val idFound = cursor.getInt(0)
        val nameFound = cursor.getString(1)
        resultados += "id: $idFound, Nombre: $nameFound\n"
      } while (cursor.moveToNext())
    }
    cursor.close()
    db.close()
    return resultados
  }

  @Throws(NumberFormatException::class)
  fun updateSql(id: Int, nombre: String) {
    Log.i(TAG, "Actualizando datos")
    val db = bdHelper!!.writableDatabase
    val sql = "update usuario set nombre ='$nombre' where id=$id"
    Log.i(TAG, "Ejecutando consulta: $sql")
    db.execSQL(sql)
    db.close()
  }

  @Throws(NumberFormatException::class)
  fun updateWithMethod(id: Int, nombre: String) {
    Log.i(TAG, "Actualizando datos con update()")
    val db = bdHelper!!.writableDatabase
    val registro = ContentValues()
    registro.put("id", id)
    registro.put("nombre", nombre)
    db.update("usuario", registro, "id=$id", null)
    db.close()
  }

  @Throws(NumberFormatException::class)
  fun deleteSql(id: Int) {
    Log.i(TAG, "Borrando datos")
    val db = bdHelper!!.writableDatabase
    val sql = "delete from usuario where id=$id"
    Log.i(TAG, "Ejecutando consulta: $sql")
    db.execSQL(sql)
    db.close()
  }

  @Throws(NumberFormatException::class)
  fun deleteWithMethod(id: Int) {
    Log.i(TAG, "Borrando datos con delete()")
    val db = bdHelper!!.writableDatabase
    db.delete("usuario", "id=$id", null)
    db.close()
  }

  override fun onDestroy() {
    Log.i(TAG, "Cerrando BD")
    bdHelper!!.close()
    super.onDestroy()
  }
}
