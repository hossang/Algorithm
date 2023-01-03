import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object Main {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var count = 0
        while (true) {
            val tmp = br.readLine() ?: break
            count++
        }
        println(count)
    }
}