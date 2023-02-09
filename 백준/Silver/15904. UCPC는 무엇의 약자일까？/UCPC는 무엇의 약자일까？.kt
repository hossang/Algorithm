import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import javax.print.attribute.IntegerSyntax
import kotlin.jvm.Throws

object Main {

    @JvmStatic
    @Throws(IOException::class)
    fun main(arr:Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
        val str = readLine()
        var i = 0

        for (c in str) when (i) {
            0 -> if (c == 'U') i++
            1, 3 -> if (c == 'C') i++
            2 -> if (c == 'P') i++
        }

        println("I " + (if (i == 4) "love" else "hate") + " UCPC")

    }
}