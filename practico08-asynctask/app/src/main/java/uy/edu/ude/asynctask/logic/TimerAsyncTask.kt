package uy.edu.ude.asynctask.logic

import android.os.AsyncTask
import android.util.Log
import uy.edu.ude.asynctask.ui.MainViewAsync

class TimerAsyncTask(val view: MainViewAsync) : AsyncTask<Void, Int, Void>() {


    override fun onPreExecute() {
        view.showBar()
    }

    //Se ejecuta en segundo plano
    override fun doInBackground(vararg params: Void?): Void? {
        for (i in 1..100) {
            // Se debe revisar la propiedad isCancelled para detener
            // la tarea en segundo plano, si la tarea asincrona se manda a cancelar sin
            // forzar, cancel(false)
            if (!isCancelled) {
                //Log.INFO("TimerAsyncTask","Execution")
                Thread.sleep(100)
                publishProgress(i)
                Log.i("TimerAsyncTask", "IsCancelled ${isCancelled} Progress $i")
            } else {
                break
            }
        }
        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        view.incrementProgress(values[0]!!)
    }

    override fun onPostExecute(result: Void?) {
        view.hideBar()
    }
}