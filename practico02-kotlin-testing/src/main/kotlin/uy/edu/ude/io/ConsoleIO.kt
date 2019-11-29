package uy.edu.ude.io

class ConsoleIO {
    fun showMessage(message: String) {
        print(message)
    }

    fun readString(): String {
        return readLine() ?: ""
    }

    fun readInt(): Int {
        return readLine()?.toInt() ?: 0
    }
}