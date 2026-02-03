package modules

import resources.ResourseManager

class ResearchLab : OutpostModule(
    "Исследовательская лаборатория"
) {
    override fun performAction(manager: ResourseManager) : ModuleResult {
        val minerals = manager.get("Minerals")

        if (minerals == null || minerals.amount < 30) {
            println("Недостаточно минералов для исследования")
            return ModuleResult.NotEnoughResources(
                resourceName = "Minerals",
                required = 30,
                available = minerals?.amount ?: 0
            )
        }
            minerals.amount -= 30
            return ModuleResult.Success("Исследование завершено")
        }
    }

fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success ->
            println("УСПЕХ: ${result.message}")

        is ModuleResult.ResourceProduced ->
            println("Произведено: ${result.resourceName} +${result.amount}")

        is ModuleResult.NotEnoughResources ->
            println(
                "Недостаточно ресурса ${result.resourceName}. " +
                "Нужно: ${result.required}, есть: ${result.available}"
            )

        is ModuleResult.Error ->
            println("ОШИБКА: ${result.reason}-")
    }
}