package characters

class OutpostWorker(val name: String) {
    var maxEnergy: Int = 100
    private set
    var energy: Int = maxEnergy
        set(value) {
            field = value.coerceIn(0, maxEnergy)
        }
    var mood: Int = 50
        get() = field + (energy / 10)
    var level: Int = 1
        private set
    fun work() {
        println("$name работает......")
        energy -= 15
        if (energy < 20) println("$name устал......")
    }
    fun rest() {
        println("$name отдыхает......")
        energy += 20
    }
    fun levelUp() {
        level++
        maxEnergy +=20
        energy = maxEnergy
        println("$name повышает уровень до $level| максимальная энергия увеличилась до $maxEnergy")
    }
}

fun main() {
    val worker = OutpostWorker("Driver")
    println("Энергия ${worker.energy}")
    println("Настроение: ${worker.mood}")
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    worker.work()
    println("Энергия ${worker.energy}")
    println("Настроение: ${worker.mood}")
    worker.energy = 150
    worker.levelUp()
}