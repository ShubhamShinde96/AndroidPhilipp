package com.shubham.daggerhilt.domain.repository

interface MyRepository {

    suspend fun doNetworkCall();
}