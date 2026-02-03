package example

interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop() {
        println("Останавливаемся...")
    }
}

class Car(
    override val model: String,
    override val number: String
): Movable {
    override var speed: Int = 100

    override fun move() {
        println("Едем на машине со скоростью $speed км/ч")
    }
}

class AirCraft(
    override val model: String,
    override val number: String
): Movable{
    override var speed: Int = 600

    override fun move() {
        println("Летим на самолете со скоростью $speed км/ч")
    }

    override fun stop() {
        println("Призамляемся")
    }
}

fun travel(obj: Movable) = obj.move()

///////////////////////////////////////////////////

interface Worker {
    fun work()
}
interface Student {
    fun study()
}

class WorkingStudent(val name: String) : Worker, Student {
    override fun work() {
        println("$name работает")
    }

    override fun study() {
        println("$name учится")
    }
}

///////////////////////////////////////////////////

interface  VideoPlayable {
    fun play() = println("Play video")
}

interface AudioPlayable {
    fun play() = println("Play audio")
}

class MediaPlayer : VideoPlayable, AudioPlayable {
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}


fun main() {
    val player = MediaPlayer()
    player.play()
    val artem = WorkingStudent("Artem")
    artem.work()
    artem.study()
    val car = Car("Rainbow", "5283")
    val airCraft = AirCraft("Fly", "5775")
    travel(car)
    travel(airCraft)
    airCraft.move()
}