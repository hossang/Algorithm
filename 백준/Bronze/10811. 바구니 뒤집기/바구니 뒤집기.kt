import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var sb = StringBuilder()
    var st = StringTokenizer(readLine(), " ")
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    var arr = Array(N,{i -> i + 1})
    for (h in 1..M) {
        st = StringTokenizer(readLine(), " ")
        var i = st.nextToken().toInt() - 1
        var j = st.nextToken().toInt() - 1
        var arr2 = Array(N, {0})
        var cnt = j - i + 1
        for (k in i..j) {
            arr2[k] = arr[k]
        }
        for (k in 1..cnt) {
            arr[i++] = arr2[j--]
        }
    }
    arr.forEach { sb.append(it).append(" ") }
    print(sb)

}
