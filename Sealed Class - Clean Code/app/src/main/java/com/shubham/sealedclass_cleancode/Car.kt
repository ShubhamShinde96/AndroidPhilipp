package com.shubham.sealedclass_cleancode

enum class Car(val model: String) {     // <T> {  enum class can't have type parameters.
    BMW("M5"),
    AUDI("R8"),
    VOLKSWAGEN("Virtus")  // We can have fix values with enum classes
}

//sealed class SealedCar<T> { // Type parameters are allowed with sealed classes.
sealed class SealedCar(val model: String) {

    class BMW(model: String) : SealedCar(model) {  // We can have dynamic values with sealed class values(Instance specific data)
        // we can have body here also & we can put functions here inside this body
        // we can have same kind of body with enum class as well but it doesn't really behave like a normal class.
    }
    object AUDI : SealedCar("")       // Singleton classes
    object VOLKSWAGEN : SealedCar("")

    // we can only extend sealed class inside sealed class & on class within the same file
    // we cannot extend the sealed class to a class which is outside file
}