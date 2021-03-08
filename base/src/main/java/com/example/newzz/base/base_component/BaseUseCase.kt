package com.example.newzz.base.base_component

abstract class BaseUseCase<Param, Result> {

    abstract suspend fun execute(param: Param, callback: (Result) -> Unit)

    suspend operator fun invoke(param: Param, callback: (Result) -> Unit) {
        return execute(param, callback)
    }
}