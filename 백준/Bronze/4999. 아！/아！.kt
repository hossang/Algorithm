import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import kotlin.jvm.Throws

object Main{
    @Throws(IOException::class)
    @JvmStatic
    fun main(args:Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var j = br.readLine().toString()
        var d = br.readLine().toString()

        if (j.length >= d.length) {
            print("go")
        } else {
            print("no")
        }
    }
}