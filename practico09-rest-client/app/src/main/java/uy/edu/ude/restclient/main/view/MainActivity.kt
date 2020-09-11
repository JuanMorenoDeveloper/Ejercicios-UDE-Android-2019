package uy.edu.ude.restclient.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import uy.edu.ude.restclient.R
import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.main.interactor.MainInteractor
import uy.edu.ude.restclient.main.presenter.MainPresenter

class MainActivity : AppCompatActivity(), View {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        presenter = MainPresenter(this, MainInteractor())
    }

    fun initComponents() {
        btnOk.setOnClickListener({ sendQuery() })
    }

    fun sendQuery() {
        // Si invocamos el servicio desde el thread principal nos va producir un error
        // val quote = QuoteApiHttpUrl("http://gturnquist-quoters.cfapps.io/api")
        // val response = quote.findQuoteById(2)
        lifecycleScope.launch {
            presenter.findQuoteByRandom()
        }
    }

    override fun updateView(response: Response) {
        tvId.text = response.id.toString()
        tvQuote.text = response.quote
        tvType.text = response.type
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
