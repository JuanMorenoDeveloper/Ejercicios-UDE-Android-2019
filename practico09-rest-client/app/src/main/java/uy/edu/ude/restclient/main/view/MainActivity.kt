package uy.edu.ude.restclient.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import uy.edu.ude.restclient.R
import uy.edu.ude.restclient.main.presenter.MainAsyncTask

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
    }

    fun initComponents() {
        btnOk.setOnClickListener({ sendQuery() })
    }

    fun sendQuery() {
        MainAsyncTask().execute("")
    }
}
