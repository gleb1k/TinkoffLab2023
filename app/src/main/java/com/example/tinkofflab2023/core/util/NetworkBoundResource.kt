package com.example.tinkofflab2023.core.util

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

inline fun <ResultType, RequestType> networkBoundResource(
    queryString: String,
    crossinline query: (String) -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }

) = flow {
    val data = query(queryString).first()

    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))

        try {
            delay(500)
            saveFetchResult(fetch())
            query(queryString).map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            query(queryString).map { Resource.Error(throwable, it) }
        }
    } else {
        query(queryString).map { Resource.Success(it) }
    }

    emitAll(flow)
}


