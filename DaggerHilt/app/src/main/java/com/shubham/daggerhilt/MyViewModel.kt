package com.shubham.daggerhilt

import androidx.lifecycle.ViewModel
import com.shubham.daggerhilt.domain.repository.MyRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
//    private val myRepository: MyRepository
    // Now take a look at lazy injection: injecting param lazy only at the time when we need it, not until that.
    private val myRepository: Lazy<MyRepository>
): ViewModel() {

    // With lazy it does not directly created when we inject it, instead it is then created when we first use it.
    // check logcat for testing this lazy initialization.

    init {
        myRepository.get() // this get is from dagger for this repository, when we call get() then the repository
        // will get created, so basically by calling get() we are making use of our repository, so comment or
        // uncomment above get() to test the Lazy initialization.
    }


}