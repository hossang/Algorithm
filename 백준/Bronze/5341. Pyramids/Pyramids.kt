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
        var sb = StringBuilder()

        while (true) {
            var n = br.readLine().toLong()
            if (n == 0L) {
                break;
            }
            sb.append(n * (n + 1) / 2).append("\n")
        }
        print(sb)
    }

}