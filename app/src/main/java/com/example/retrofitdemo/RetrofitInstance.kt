package com.example.retrofitdemo

import NewsResponse
import com.example.retrofitdemo.Constants.Companion.baseUrl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

 private val moshi= Moshi.Builder()
     .add(KotlinJsonAdapterFactory())
     .build()

private var  retrofit= Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(baseUrl)
    .build()

val api by lazy {
    retrofit.create(apiInterface::class.java)
}
