import java.util.*
import java.io.*

object Main {
    
   @JvmStatic
   @Throws(IOException::class)
   fun main (arg:Array<String>) {
       var br = BufferedReader(InputStreamReader(System.`in`))
       print(br.readLine().toInt()*24)
   }
}
