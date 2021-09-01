package com.proway.injecao_depencia_com_api.di

import com.proway.injecao_depencia_com_api.repository.GitUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideGitRepository() : GitUserRepository = GitUserRepository()
}