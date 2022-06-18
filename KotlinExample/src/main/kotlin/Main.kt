import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    // なんでこれで true/false になる？
    val greaterThan = Num(5) > Num(1)
    val lessThan = Num(5) < Num(1)
    println(greaterThan)
    println(lessThan)

    // "Call Java class" is way too easy.
    val hello = HelloByJava()
    hello.printHello()

    // call Java Library
    val uuid: UUID = UUID.randomUUID()
    println(uuid.toString())
}

data class Num(val value: Int) {
    operator fun compareTo(num: Num): Int {
        return value.compareTo(num.value)
    }
}
