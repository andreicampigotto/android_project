package com.proway.curl_routines.di

import com.proway.curl_routines.service.GitService
import com.proway.curl_routines.service.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideGitService(): GitService = RetrofitService.getRepositories()
}