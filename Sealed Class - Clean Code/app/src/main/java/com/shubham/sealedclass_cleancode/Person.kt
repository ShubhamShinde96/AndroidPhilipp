package com.shubham.sealedclass_cleancode

data class Person(
    val name: String,
    val gender: Gender = Gender.Female
) {

    sealed class Gender {

        object Male: Gender()
        object Female: Gender()
    }
}
