import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import javax.print.attribute.IntegerSyntax
import kotlin.jvm.Throws

object Main {

    @JvmStatic
    @Throws(IOException::class)
    fun main(arr:Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
        print(readLine().toInt() * readLine().toInt())

    }
}