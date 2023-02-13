import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(arr: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine(), " ")
    var N = st.nextToken().toInt() //끊어진 줄
    var M = st.nextToken().toInt() //브랜드 갯수

    var sixs = Array(M) {0}
    var ones = Array(M) {0}
    for (i in 0..M-1) {
        st = StringTokenizer(readLine(), " ")
        sixs[i] = st.nextToken().toInt()
        if (sixs[i] == 0) {
            print(0)
            return
        }
        ones[i] = st.nextToken().toInt()
        if (ones[i] == 0) {
            print(0)
            return
        }
    }
    Arrays.sort(sixs)
    Arrays.sort(ones)
    var a = sixs[0] / ones[0] //a번째 이상이면 6개 사는 게 나음
    if (a > 6) {
        print(ones[0] * N)
        return
    }
    var b = N / 6  * sixs[0]
    if (N % 6 <= a) {
        b += N % 6 * ones[0]
    } else {
        b += sixs[0]
    }
    print(b)
}
