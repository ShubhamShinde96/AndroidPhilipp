fun main() {

    // Higher Order Functions: High order function (Higher Level Function) is a function which
    // accepts function as a parameter or returns a function or can do both.
    // Means, instead of passing Int, String or any other types as a parameter to a function
    // we can pass a function as a parameter in other function.

    val myFun = higherOrder(2.0, 3.0, ::add) //storing this "higherOrder" function inside a variable.
    println(myFun)
}

fun add(a: Double, b: Double): Double {
    return a + b
}

fun higherOrder(a: Double, b: Double, fn: (Double, Double) -> Double): Double {
    // So this is our higher order function which is expecting 2 double values & 1 function

    println(fn(a, b))
    return a + b
}

// In kotlin we treat a function as an object itself, like we can pass function as a param to a function
// we can return a function from a function,
// or we can store a function inside a variable also


