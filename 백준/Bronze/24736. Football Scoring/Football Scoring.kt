import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var sb = StringBuilder()
    for (i in 1..2) {
        var arr = readLine().split(' ').map { it.toInt() }
        sb.append(arr[0] * 6 + arr[1] * 3 + arr[2] * 2 + arr[3] * 1 + arr[4] * 2).append(" ")
    }
    print(sb)
}
