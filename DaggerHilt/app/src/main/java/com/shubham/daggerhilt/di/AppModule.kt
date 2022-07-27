package com.shubham.daggerhilt.di

import android.app.Application
import com.shubham.daggerhilt.data.remote.MyApi
import com.shubham.daggerhilt.data.repository.MyRepositoryImpl
import com.shubham.daggerhilt.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // will live as long as whole application does
//@InstallIn(ActivityComponent::class)  // Will live as long as the activity does
//@InstallIn(ViewModelComponent::class)  // Will live as long as the viewmodel does
//@InstallIn(ActivityRetainedComponent::class)  // The purpose of this is it does not get
// destroyed if your screen is rotated and gets recreated.
//@InstallIn(ServiceComponent::class) // For services
object AppModule  {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {

        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }

    /*@Provides
    @Singleton
    fun provideMyRepository(
        myApi: MyApi,
        app: Application,
        @Named("hello1") hello1: String
    ): MyRepository {

        return MyRepositoryImpl(myApi, app)
    }*/

    // in above fun we are defining the return type as our abstraction interface and returning it's
    // implementation which is MyRepositoryImpl, then create another module for this we have a simple solution which has shown below.



    // One more question is: What happens if you actually have 2 dependencies of the same type, how does dagger-hilt
    // know which one it should inject?

    // now we have created 2 provider function with same return type, which is string, and we are now expecting
    // a string param in above provideMyRepository(), so now how does dagger-hilt know exactly which string obj
    // we want to expect there.
    // So now if you try to compile at this stage then you'll get compile time error
    // which is: String is bound multiple times @Provides @Singleton...

    // So luckily there's a easy fix and that is using  @Named annotation from dagger-hilt
    // see how we have used it below

    @Provides
    @Singleton
    @Named("hello1") // So we can basically give this dependency a unique name to differentiate between similar types.
    // and whenever we inject this dependency we also need to provide this @Named annotation there
    fun providesString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun providesString2() = "Hello 2"

}