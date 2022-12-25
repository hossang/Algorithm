import kotlin.Throws
import java.io.IOException
import kotlin.jvm.JvmStatic
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

object Main {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        //초기화
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine(), " ")
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        var max = Int.MIN_VALUE
        val arr = Array(n + 3) { IntArray(m + 3) }
        for (i in 0 until n) {
            st = StringTokenizer(br.readLine(), " ")
            for (j in 0 until m) {
                arr[i][j] = st.nextToken().toInt()
            }
            for (j in m until m + 3) {
                arr[i][j] = -9999999
            }
        }
        for (i in n until n + 3) {
            for (j in 0 until m + 3) {
                arr[i][j] = -9999999
            }
        }
        val tetriminos = arrayOf(
            arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(1, 1, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(0, 1, 1, 0), intArrayOf(1, 1, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(0, 1, 0, 0), intArrayOf(1, 1, 0, 0), intArrayOf(1, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 1, 0, 0), intArrayOf(0, 1, 1, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 1, 1, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(0, 1, 0, 0), intArrayOf(1, 1, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(0, 1, 0, 0), intArrayOf(1, 1, 1, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(1, 1, 0, 0), intArrayOf(1, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 1, 1, 1), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(1, 0, 0, 0), intArrayOf(1, 0, 0, 0), intArrayOf(1, 0, 0, 0)),
            arrayOf(intArrayOf(1, 1, 0, 0), intArrayOf(1, 1, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(1, 0, 0, 0), intArrayOf(1, 1, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 1, 1, 0), intArrayOf(1, 0, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 1, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(0, 0, 1, 0), intArrayOf(1, 1, 1, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(0, 1, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(1, 1, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(1, 1, 1, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 1, 0, 0), intArrayOf(1, 0, 0, 0), intArrayOf(1, 0, 0, 0), intArrayOf(0, 0, 0, 0)),
            arrayOf(intArrayOf(1, 1, 1, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0))
        )
        for (i in 0..18) {
            for (j in 0 until n) {
                for (k in 0 until m) {
                    var tmp = 0
                    for (l in 0..3) {
                        for (o in 0..3) {
                            tmp += arr[j + l][k + o] * tetriminos[i][l][o]
                        }
                    }
                    if (max < tmp) {
                        max = tmp
                    }
                }
            }
        }
        println(max)
    }
}