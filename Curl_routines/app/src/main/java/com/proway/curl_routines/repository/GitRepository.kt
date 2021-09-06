package com.proway.curl_routines.repository

import com.proway.curl_routines.model.RepositoryResponse
import com.proway.curl_routines.service.GitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Response
import javax.inject.Inject

class GitRepository @Inject constructor(private val service: GitService) {

    suspend fun getRepositories(): Deferred<RepositoryResponse?> {
        return CoroutineScope(Dispatchers.Default).async {
            val response =
                service.fetchRepositories(language = "language:Kotlin", page = 1, sort = "stars")
            processData(response)
        }
    }

    fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }
}