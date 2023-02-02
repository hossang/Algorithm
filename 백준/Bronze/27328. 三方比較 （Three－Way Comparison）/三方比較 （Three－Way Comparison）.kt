import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import javax.print.attribute.IntegerSyntax
import kotlin.jvm.Throws

object Main {

    @JvmStatic
    @Throws(IOException::class)
    fun main(arg:Array<String>) {
        var br = BufferedReader(InputStreamReader(System.`in`))
        var a = br.readLine().toInt()
        var b = br.readLine().toInt()
        if (a > b) {
            print(1)
        } else if (a == b) {
            print(0)
        } else {
            print(-1)
        }
    }
}