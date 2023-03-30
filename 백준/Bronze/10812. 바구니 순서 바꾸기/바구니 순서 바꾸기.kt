import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var sb = StringBuilder()
    var st = StringTokenizer(readLine(), " ")
    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()

    var arr1 = Array(N+1, {i -> i})

    for (h in 1..M) {
        st = StringTokenizer(readLine(), " ")
        var i = st.nextToken().toInt()
        var j = st.nextToken().toInt()
        var k = st.nextToken().toInt()
        var arr2 = Array(j-i+1,{0})
        var idx = 0
        for (l in k..j) {
            arr2[idx++] = arr1[l]
        }
        for (l in i..k - 1) {
            arr2[idx++] = arr1[l]
        }
        idx = 0
        for (l in i..j) {
            arr1[l] = arr2[idx++]
        }
    }
    for (i in 1..N) {
        sb.append(arr1[i]).append(" ")
    }
    print(sb)
}
