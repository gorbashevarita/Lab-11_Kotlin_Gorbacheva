object GameSession {
    init {
        println("Игровая сессия создана")
    }

    var isActive: Boolean = false
    fun start() {
        isActive = true
        println("Игра началась")
    }

    fun end() {
        isActive = false
        println("Игра завершена")
    }
}

object Logger {
    var count = 0

    fun log(message: String) {
        count++
        println("[$count] $message")
    }
}
object AppSettings {
    val version = "1.0.0"
    var isDarkMode = true

    fun checkTheme() {
        if (AppSettings.isDarkMode) {
            println("Темная тема включена")
        }
    }
}
object Colors {
    const val RED = "#FF0000"
    const val GREEN = "#00FF00"
    const val BLUE = "#0000FF"
    fun main() {
        println(Colors.RED)
        println(Colors.GREEN)
        println(Colors.BLUE)
    }
}

class MyCar(val model: String) {
    fun drive() = println("$model едет")
}
object TrafficController {
    var carCount = 0
    fun carPassed() {
        carCount++
    }
}