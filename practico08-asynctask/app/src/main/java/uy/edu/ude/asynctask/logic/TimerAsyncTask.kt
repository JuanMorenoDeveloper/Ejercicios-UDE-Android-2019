package uy.edu.ude.asynctask.logic

import android.os.AsyncTask
import android.util.Log
import uy.edu.ude.asynctask.ui.MainViewAsync

class TimerAsyncTask(val view: MainViewAsync) : AsyncTask<Void, Int, Void>() {


    override fun onPreExecute() {
        view.showBar()
    }

    override fun doInBackground(vararg params: Void?): Void? {
        for (i in 1..100) {
//            if (!isCancelled) {
            //Log.INFO("TimerAsyncTask","Execution")
            Thread.sleep(100)
            publishProgress(i)
            Log.i("TimerAsyncTask", "IsCancelled ${isCancelled} Progress $i")
//            }
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