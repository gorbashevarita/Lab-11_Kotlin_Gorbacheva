package modules

import resources.ResourseManager

class ResearchLab : OutpostModule(
    "Исследовательская лаборатория"
) {
    override fun performAction(manager: ResourseManager) {
        val minerals = manager.get("Minerals")

        if (minerals == null || minerals.amount < 30) {
            println("Недостаточно минералов для исследования")
            return
        } else {
            minerals.amount -= 30
            println("Лаборатория проводит исследования (минералы -30)")
        }
    }
}