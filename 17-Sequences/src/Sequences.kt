fun main() {


    val immutableMap = mapOf<Int, Car>(1 to Car("Green", "Toyota", 2015),
        2 to Car("Red", "Ford", 2016),
        3 to Car("Silver", "Honda", 2013),
        17 to Car("Red", "BMW", 2015),
        8 to Car("Green", "Ford", 2010))

    println(immutableMap.filter { it.value.model == "Ford" }
        .map { it.value.color })  // here this works fine, but what if we have collection of thousands of items
    // we have to avoid performing more operation on intermediate collections, like we are doing in above example.
    // we have to use sequences for that. You can avoid intermediate collections using sequences.

    // When we do this the "filter" call returns a "collection" & then the "map" is called on the "collection"
    // which we got from "filter".
    // But what if we are using multiple "filter" or similar functions on that collection, then it's going to remember
    // a copy of each resulting collection returned by "filter" or similar function and perform next operation on that
    // and if at the same time if the data is huge then it's going to be a memory overhead.
    // So this is where sequence comes in
    // When you work with sequences then here each element is evaluated(checked if satisfy with condition that we've
    // passed) individually, and it gets passed to the next step in the chain (if one condition is failed then it will not
    // pass it for the next condition).
    // So as it checks all condition one by one ON one by one item there is no need to create any intermediate collection
    // of each condition instances

    // Another use-case of sequences is if you don't know how many items you're gonna fill in, depends on your API call, here sequence will work.

    println("-------------------------------------------------------------------")

    println(immutableMap.asSequence().filter { it.value.model == "Ford" }
        .map { it.value.color }) // Now second condition will be checked if first condition is satisfied in this case of sequences. This is the difference between sequences and map

    println(immutableMap.asSequence().filter { it.value.model == "Ford" }
        .map { it.value.color }
        .toList())  // this will work, need to use toList() otherwise you'll get an output like: kotlin.sequences.TransformingSequence@65b54208
    // understand the reason behind this behaviour by watching course video, need to work on DS part


    println("-------------------------------------------------------------------")

    listOf("Joe", "Marry", "Jane").asSequence()
        .filter { println("Filtering $it"); it[0] == 'J' }   // This is another use of semicolon in kotlin
        .map { println("Mapping $it"); it.uppercase() }
        .find { it.endsWith("E") } // capital "E" because we've uppercased it
//        .toList() // .toList() is a terminal operation in sequence
    // This is similar to streams in java.

    // Sequences are lazily evaluated, so they're not evaluated until the terminal operation has performed.

    println("***********************************************************")

    val res = listOf("Joe", "Marry", "Jane", "John").asSequence()
        .filter { println("Filtering $it"); it[0] == 'J' && it[it.length - 1] == 'e'}   // This is another use of semicolon in kotlin
//        .filter { it[it.length - 1] == 'e' }
        .map { println("Mapping $it"); it.uppercase() }
        .toList()

    println("")
    println("Result is: $res")


    // Must rewatch all video regarding sequences from our course



}

data class Car(val color: String, val model: String, val year: Int) {


}





