package com.fitness.framework.state

sealed class DataState<out T> {
    data class Success<out T>(val result: T) : DataState<T>()
    data class Error(val error: Throwable) : DataState<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$result]"
            is Error -> "Error[exception=$error]"
        }
    }

    inline fun <R: Any> map(transform: (T) -> R): DataState<R> {
        return when(this){
            is Error -> Error(this.error)
            is Success -> Success(transform(this.result))
        }
    }
}