package com.shubham.kotlinscopefunctions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var number: Int? = null

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Kotlin Scope Functions:
        // We have let, also, apply and run and there's also "with" but that's also same as "run"

        // Here we're going to see the difference between these functions & we'll get rid of the confusions here
        // about in which case we should pick which scope function.

        // Starting off with most commonly used function that is "let"
        // We use let for null checks in kotlin
        // if we use "if" condition here then

        // * * * * * * * * * * * * * * * * * * * * * * * 1] let * * * * * * * * * * * * * * * * * * * * * * * * * *

        if(number != null) {
//            val number2 = number + 1 // so we are getting an error here, that's because we've declared "number"
            // variable globally and here after checking number != null and by the time we reach at line we're accessing
            // number var some another thread might set it's value back to null.
            // And as the kotlin is a null safe language, this is something that should not happen here.
//            val number2 = number!! + 1 // here we can assert like this that number var is not null but this is not ideal.
        }

        // so what we can do here is we can use let
        number?.let {
            val number2 = it + 1 // so here let function basically holding the value of "number" var into "it"
            // so even if some other thread change it's value to null here we're accessing the value of "it"
            // so we're going to get the value of number variable when we checked it is not null by doing "number?.let"

            // So "it" is basically state of that "number" variable.
        }

        val x = number?.let {
            val number2 = it + 1
            number2     //here before returning the number2 variable the value of x is Unit?
//            return@let number2
            // And after returning the number2 the x val is nullable because while we're checking the number var
            // is not null if it turns out to be null then the let function will be able to assign null value to x.
        }

        val x2 = number?.let {
            val number2 = it + 1
            number2
        } ?: 3   // this is how you can use elvis operator to perform else condition.


        // * * * * * * * * * * * * * * * * * * * * * * * 2] also * * * * * * * * * * * * * * * * * * * * * * * * * *

        // also is very similar to let, so you can call also on
        // "also" does not let you to return the value like we did with let, we returned "number2" for val x
        // instead "also" will return the object it was called on.
        // consider below function getSquaredI() for "also" scope function ex.

        // * * * * * * * * * * * * * * * * * * * * * * * 3] apply * * * * * * * * * * * * * * * * * * * * * * * * * *

        // "apply" is very commonly used
        // "apply" can also just like every other scoped function, is very helpful to modify the objects.
        // So if you need to do a lot of changes in particular object then you should use "apply".
        // For ex:
        val intent = Intent().apply {
            // with "apply" we get "this" reference.
            // So we don't need to use "it" all the time, instead we can call all the functions directly without
            // needing to reference to "it" or that particular object on which "apply" is called on.
            putExtra("", "")  // just like this
            // Otherwise we would have to do
//            Intent().putExtra("", "")
//            intent.putExtra("", "") everytime we need to perform anything on Intent() obj
            putExtra("", "")
            action = ""  // Note: here we're not returning this "action" var, this "action" is actually a setAction() method of intent
        }



        // * * * * * * * * * * * * * * * * * * * * * * * 4] run * * * * * * * * * * * * * * * * * * * * * * * * * *

        val intent2 = Intent().run {

            // here we're just used "run" instead of "apply"
            // difference is if you keep your cursor on "intent2" & press Ctrl + q then you'll get to know that
            // "run" scope function is having "Unit" type and if you see the info of above intent we used for
            // "apply" then you'll see that it is having "Intent" type
            // because run is equivalent to apply the same way as let is equivalent to also, so that means run will
            // do the same as apply but it won't return the object it was called on, instead it will return the last line
            // which is "action" in this case.

            putExtra("", "")
            putExtra("", "")
            action = ""  // and because the "action" is unit here so that the type of "intent2" will be "Unit"
            // so if you type "this" below then you'll see the type of "intent2" will be "Intent"
            // this is because "this" is the last line in this run function & here "this" refers to the "this: Intent" here.
            this
        }

        // So that's why we use "apply" more often than "run".

        // * * * * * * * * * * * * * * * * * * * * * * * 5] with * * * * * * * * * * * * * * * * * * * * * * * * * *

        // so philipp not uses "with" as much, actually he uses it very very rarely
        // "with" is same as run, just the signature is different

        with(Intent()) {

            // here you'll also get the reference to "this" reference to Intent()
            // so this is the only difference in "run" & "with"
        }
    }


    fun getSquaredI() = (i * i).also {

        // here "it" refers to the value of "i", but if you want to increase the value of 'i' variable then you need
        // to do it like below
        i++

    } // so this is how we can also use "also"
    // so we can now still use that single line expression here & still actually do multiple things


}




