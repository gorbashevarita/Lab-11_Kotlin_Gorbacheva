package example

object SystemLogger {
    init {
        println("SystemLogger инициализирован")
    }
    fun log(message: String) {
        println("[LOG] $message")
    }
}
val logger by lazy {
    SystemLogger
}