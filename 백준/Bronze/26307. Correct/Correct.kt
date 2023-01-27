import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import javax.print.attribute.IntegerSyntax
import kotlin.jvm.Throws

object Main {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine(), " ")
        var h = st.nextToken().toInt()
        var m = st.nextToken().toInt()

        print((h - 9) * 60 + m)
    }
}