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
        var N = br.readLine().toInt()
        var fact = arrayOf("1", "1", "2", "6", "24", "120", "720", "5040"
            , "40320", "362880", "3628800", "39916800", "479001600", "6227020800"
            , "87178291200", "1307674368000", "20922789888000", "355687428096000"
            , "6402373705728000", "121645100408832000", "2432902008176640000")
        print(fact.get(N))
    }
}