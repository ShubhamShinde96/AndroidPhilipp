

fun main() {

    var shapes = listOf(Circle(5.0),
        Circle(3.5),
        Circle(4.1),
        Circle(3.4),
        Circle(6.9),
        Circle(2.7),
        Circle(1.6),)

    var list  = (1..20).toList()

    println(list)

    list = list.filter { it % 2 == 0 }
    println(list)

    val circle1 = Circle(5.0)
    val circle2 = Circle(23.5)
    val triangle1 = Triangle(4.0, 4.0, 4.0)
    val triangle2 = Triangle(3.0, 3.0, 3.0)
    val triangle3 = Triangle(4.0, 4.0, 4.0)

    Event("Shubham")
    Event<String>()
    Event(256)

    Event2("Shubham",256,  56.36)
    Event2(56.36, 256, "Shubham" )
    Event2(256, "Shubham", 56.36)

}

data class Circle(val radious: Double)

data class Triangle(val a: Double, val b: Double, val c: Double)

//fun List<Circle>

class Event<T> (value: T? = null) {

    init {
        println(value.toString().length)
    }
}

class Event2<T, V, B> (value: T? = null, data: V, base: B) {

    init {
        println(value.toString().length)
    }
}

