package uy.edu.ude.restmarvel

import com.google.common.base.Charsets
import com.google.common.hash.Hashing
import org.junit.Test

class EmptyUnitTest {
    @Test
    fun test() {
        println(hash())
    }

    fun hash(): String {
        val apiKey = "108f278315cda02a5803401df0c0ee4a"
        val privateKey = "a921cbf3c04d7b44b934279888a15ff34a9c8c5e"
        val timestamp = System.currentTimeMillis()

        return Hashing.md5().hashString(
            timestamp.toString() + privateKey + apiKey,
            Charsets.UTF_8
        ).toString()!!
    }
}