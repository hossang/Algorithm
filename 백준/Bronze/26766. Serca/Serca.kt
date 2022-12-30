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
        for (i in 1..n) {
            println("""
             @@@   @@@ 
            @   @ @   @
            @    @    @
            @         @
             @       @ 
              @     @  
               @   @   
                @ @    
                 @     
        """.trimIndent())
        }

    }
}