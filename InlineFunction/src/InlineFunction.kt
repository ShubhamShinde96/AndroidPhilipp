fun main() {

    // An inline function is declared with keyword "inline"
    // The use of inline function enhances the performance of higher order functions.
    // The inline function tells the compiler to copy parameters and function to the call site.

    inlineFunction { println("Calling inline function") }

    inlineFunction { println("Calling inline function") }

    inlineFunction { println("Calling inline function") }


    // now the advantage of making a function inline is that if you go to:
    // Tools > kotlin > Show Bytecode
    // There you'll see if you have used a lambda/high order function what kotlin does is
    // kotlin internally creates a separate class and separate instance for every lambda we have created
    // now if you make fun inline then kotlin just copies the code of inline function into the same function
    // where it was called.
    // so if you decompile the code for both the cases then you'll see the difference
    // So it is bad practice to use lambda frequently, instead of that we have to go with
    // inline function frequently

    /*inline fun show() {

    }*/ // this is not allowed, cause making function inline is only allowed
    // for global functions and not for the local functions
}

inline fun inlineFunction(fn: () -> Unit) {
    fn()
    println("Code inside inline function")
}