package com.example.tinkofflab2023.di.module

import android.content.Context
import com.example.tinkofflab2023.ui.util.ViewGenerator
import com.example.tinkofflab2023.ui.util.ViewModifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideViewGenerator(
        @ApplicationContext context: Context
    ): ViewGenerator = ViewGenerator(context)

    @Provides
    fun provideViewModifier(
        @ApplicationContext context: Context
    ): ViewModifier = ViewModifier(context)
}
