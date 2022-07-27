import com.sun.org.apache.xpath.internal.operations.Bool

fun main() {

    // Lambda is a function which has no name. Lambda is defined with a curly braces { }
    // which takes variable as a parameter (if any) and body of a function.
    // The body of function is written after variable (if any) followed by -> operator.

    val modOperation = { a: Int -> a % 2 == 0  } // Int because we want "a" is a type of number, specially int.

    println(modOperation(4))

//    val myFun = higherOrder(2.0, 3.0, ::add) // Now we don't want to pass the function like this, cause the drawback
    // of this approach is we have to create one more add function so that we can pass it here like this ::add
    // but with lambda fun we can directly write here the lambda function instead of writing it separately & then calling it.
//    val myFun = higherOrder(2.0, 3.0, { a: Double, b: Double -> a + b }) // like this
    val myFun = higherOrder(2.0, 3.0) { a: Double, b: Double -> a + b } // so if lambda fun is our last param
    // then we should keep it outside the block like this,this is the recommended way.
    println(myFun)


    // with type annotation in lambda expression
    val sum1 = { a: Int, b: Int -> a + b }

    // without type annotation in lambda expression
    val sum2:(Int,Int)-> Int  = { a , b -> a + b}

    // directly print the return value of lambda
    // without storing in a variable.
    println(sum1(5,7))



    val sum1Str = { a: Int, b: Int ->
        val num = a + b
        num.toString()     //convert Integer to String
    }

    val str = sum1Str(1, 3)
    println("The sum of two numbers is: $str")
}

fun add(a: Double, b: Double): Double {
    return a + b
}

// Now we want to convert following higher order function into a lambda function.
fun higherOrder(a: Double, b: Double, fn: (Double, Double) -> Double): Double {

    println(fn(a, b))
    return a + b
}


