import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var sb = StringBuilder()
    val N = readLine().toInt()
    for (i in 1..N) {
        var x = readLine().toInt()
        sb.append(x).append(" ").append(x).append("\n")
    }
    print(sb)
}
