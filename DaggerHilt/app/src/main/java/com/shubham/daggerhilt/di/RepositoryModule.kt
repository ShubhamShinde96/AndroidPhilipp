package com.shubham.daggerhilt.di

import com.shubham.daggerhilt.data.repository.MyRepositoryImpl
import com.shubham.daggerhilt.domain.repository.MyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRepository( // this binds function just make sure that
        myRepositoryImpl: MyRepositoryImpl // <- this specific impl is chosen
    ): MyRepository // whenever we try to inject <- this abstraction.

    // We don't need any function body here, because it is an abstract function

    // we also need to use "@Inject constructor" for our repository impl class that we are trying to @Bind and provide here.

    // whenever any type of class in your app has "@Inject constructor" you don't need any provides function for that.

    // So this is a different way of providing the dependency and that always works if you want to provide an
    // interface or an abstract class

    // The benefit of this is that dagger-hilt will generate little bit less code for injecting such interfaces
    // or abstract classes then if you have that as an provider function, which are functionality wise equivalent.
    // but philipp prefers this way of injecting interfaces and abstract classes.
}