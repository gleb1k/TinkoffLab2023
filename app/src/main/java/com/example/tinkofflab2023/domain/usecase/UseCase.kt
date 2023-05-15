package com.example.tinkofflab2023.domain.usecase

interface UseCase

//abstract class UseCase<in P, R> {
//
//    suspend operator fun invoke(parameters: P): Resource<R> {
//        return try {
//            execute(parameters).let {
//                Resource.Success(it)
//            }
//
//        } catch (e: Exception) {
//            Timber.d(e)
//            Resource.Error(e)
//        }
//    }
//
//    @Throws(RuntimeException::class)
//    protected abstract suspend fun execute(parameters: P): R
//}
//
//class GetListUseCase @Inject constructor(
//    private val coroutineDispatcher: CoroutineDispatcher,
//    private val remoteRepository: RemoteRepository
//): UseCase<ListRequest,ItemsList>(coroutineDispatcher) {
//
//    override suspend fun execute(parameters: ListRequest): ItemsList{
//        return remoteRepository.getList(parameters)
//    }
//
//}
