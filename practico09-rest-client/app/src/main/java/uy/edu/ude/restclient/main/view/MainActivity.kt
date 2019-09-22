package uy.edu.ude.restclient.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import uy.edu.ude.restclient.R
import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.main.presenter.MainPresenter

class MainActivity : AppCompatActivity(), View {

    var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        presenter = MainPresenter(this)
    }

    fun initComponents() {
        btnOk.setOnClickListener({ sendQuery() })
    }

    fun sendQuery() {
        // Si invocamos el servicio desde el thread principal nos va producir un error
        // val quote = QuoteApiHttpUrl("http://gturnquist-quoters.cfapps.io/api")
        // val response = quote.findQuoteById(2)
        presenter?.findQuoteByRandom()
    }

    override fun updateView(response: Response) {
        tvId.text = response.id.toString()
        tvQuote.text = response.quote
        tvType.text = response.type
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }
}
