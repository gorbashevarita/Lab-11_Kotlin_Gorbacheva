package example

var age: Int = 18
    set(value) {
        if ((value > 0) and (value < 100))
            field = value
    }
data class Item(
    val id: Int,
    val name: String,
    val guantity: Int
) {
    override fun toString(): String {
        return "ID: $id | name: $name | guantity: $guantity"
    }
}

abstract class Human(val name: String) {
    abstract var age: Int
    abstract fun hello()
}

class Person(name: String, override var age: Int = 0) : Human(name) {
    // override var example.age: Int = 0

    override fun hello() {
        println("My name is $name")
    }
}

abstract class Figure () {
    abstract fun perimeter() : Float
    abstract fun area() : Float
}

class Rectangle(
    val wight: Float,
    val height: Float
) : Figure() {
    override fun perimeter(): Float {
        return  2 * (wight + height)
    }

    override fun area(): Float {
        return wight * height
    }
}

fun main() {
//    println(example.age)
    age = 45
    println(age)
    age = -345
    println(age)
    val denis: Human = Person ("Denis", 23)
    val anton: Human = Person ("Anton", 18)
}