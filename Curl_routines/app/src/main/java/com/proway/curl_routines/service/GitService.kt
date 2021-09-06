package com.proway.curl_routines.service

import com.proway.curl_routines.model.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitService {

    @GET("/search/repositories")
    suspend fun fetchRepositories(
        @Query("q") language: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
    ): Response<RepositoryResponse>
}