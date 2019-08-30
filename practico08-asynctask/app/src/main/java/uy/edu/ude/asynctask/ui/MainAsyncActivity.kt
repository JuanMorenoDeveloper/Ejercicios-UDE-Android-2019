package uy.edu.ude.asynctask.ui

import android.os.Bundle

import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import uy.edu.ude.asynctask.R
import uy.edu.ude.asynctask.logic.TimerAsyncTask

class MainAsyncActivity : AppCompatActivity(), MainViewAsync {
    private lateinit var btnOk: Button
    private lateinit var btnCancel: Button
    private lateinit var pbNumeric: ProgressBar
    private lateinit var timerAsync: TimerAsyncTask

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_async)
        initUiComponents()
    }

    private fun initUiComponents() {
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)
        pbNumeric = findViewById(R.id.pbNumeric)
        btnOk.setOnClickListener({
            timerAsync = TimerAsyncTask(this)
            timerAsync.execute()
        })
        btnCancel.setOnClickListener({
            val isCancel = timerAsync.cancel(true)
            Log.i("MainAsyncActivity", "$isCancel")
        })
    }

    override fun showBar() {
        pbNumeric.visibility = VISIBLE
    }

    override fun incrementProgress(progress: Int) {
        pbNumeric.progress = progress
    }

    override fun hideBar() {
        pbNumeric.visibility = INVISIBLE
    }

}
