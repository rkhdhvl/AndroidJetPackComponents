package com.practice.androidjetpackcomponents.openapi.di

import android.app.Application
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.codingwithmitch.openapi.util.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.practice.androidjetpackcomponents.R
import com.practice.androidjetpackcomponents.openapi.persistence.AccountPropertiesDao
import com.practice.androidjetpackcomponents.openapi.persistence.AppDatabase
import com.practice.androidjetpackcomponents.openapi.persistence.AppDatabase.Companion.DATABASE_NAME
import com.practice.androidjetpackcomponents.openapi.persistence.AuthTokenDao
import com.practice.androidjetpackcomponents.openapi.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideAppDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder():Gson{
       return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gson:Gson):Retrofit.Builder
    {
      return Retrofit.Builder()
          .baseUrl(Constants.BASE_URL)
          .addCallAdapterFactory(LiveDataCallAdapterFactory())
          .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideAuthTokenDao(db: AppDatabase): AuthTokenDao {
        return db.getAuthTokenDao()
    }

    @Singleton
    @Provides
    fun provideAccountPropertiesDao(db: AppDatabase): AccountPropertiesDao {
        return db.getAccountPropertiesDao()
    }

    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.default_image)
            .error(R.drawable.default_image)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

}