package outpostState

import java.io.File

class StateStorage(private val filename: String = "outpost_state.txt") {

    fun save(resources: List<ObservableResource>) {
        val lines = resources.map { "${it.name},${it.amount}" }
        File(filename).writeText(lines.joinToString(separator = "\n"))
        println("Состояние сохранено в $filename")
    }

    fun load(): List<ObservableResource> {
        if (!File(filename).exists()) {
            println("Файл $filename не найден. Создан пустой список ресурсов.")
            return emptyList()
        }

        val lines = File(filename).readLines()
        val resources = lines.mapNotNull { line ->
            val parts = line.split(",")
            if (parts.size != 2) return@mapNotNull null

            val name = parts[0]
            val amount = parts[1].toIntOrNull() ?: return@mapNotNull null

            ObservableResource(name, amount)
        }
        println("Состояние загружено из $filename")
        return resources
    }
}
