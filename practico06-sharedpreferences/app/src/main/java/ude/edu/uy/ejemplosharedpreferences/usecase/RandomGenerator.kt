package ude.edu.uy.ejemplosharedpreferences.usecase

import java.util.*

class RandomGenerator(val maxValue: Int) : Generator {
    companion object {
        val random = Random()
    }

    override fun nextValue(): Int {
        return random.nextInt(maxValue)
    }

}