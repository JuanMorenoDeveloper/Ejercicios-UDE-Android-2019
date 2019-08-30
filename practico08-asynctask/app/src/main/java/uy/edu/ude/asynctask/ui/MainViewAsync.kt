package uy.edu.ude.asynctask.ui

interface MainViewAsync {
    fun showBar()
    fun incrementProgress(progress: Int)
    fun hideBar()
}