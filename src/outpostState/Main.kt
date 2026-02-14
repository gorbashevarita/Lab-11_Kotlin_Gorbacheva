package outpostState

fun main() {
    println("=== Запуск системы аванпоста ===\n")

    println("Обращаемся к outpostManager (инициализация)...")
    outpostManager.addResource(ObservableResource("Minerals", 100))
    outpostManager.addResource(ObservableResource("Energy", 50))


    println("\nИзменяем ресурсы:")
    outpostManager.resources[0].amount = 120  // Minerals
    outpostManager.resources[1].amount = 75   // Energy


    println("\nСохраняем состояние...")
    val storage = StateStorage()
    storage.save(outpostManager.resources)

    println("\nЗагружаем состояние...")
    val loadedResources = storage.load()

    println("\nТекущее состояние ресурсов:")
    loadedResources.forEach { resource ->
        println("- ${resource.name}: ${resource.amount}")
    }

    println("\n Завершение работы")
}
