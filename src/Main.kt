import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourseManager

fun main() {
    val manager = ResourseManager()
    manager.add(OutpostResource(1, "Minerals", 120))
    manager.add(OutpostResource(2, "Gas", 40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()
//    val gas = resources.OutpostResource(1, "Gas", 100)
//    val mineral = resources.OutpostResource(2, "Mineral", 300)
//    manager.add(gas)
//    manager.add(mineral)
//    manager.printAll()
//    val bonusMineral = mineral.copy(id = 3, name = "Mineral Bonus", amount = mineral.amount + 50)
//    println("Бонусные минералы: $bonusMineral")
}