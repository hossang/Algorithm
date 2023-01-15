import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val a = sc.nextInt()
        val b = sc.nextInt()
        if (a < b) println("-1") else {
            val x = (a + b) / 2
            val y = (a - b) / 2
            if (x + y == a && x - y == b) println("$x $y") else println("-1")
        }
    }
}