package com.example.nesinecase.util

import com.example.nesinecase.enum.RepositoryStatus

class DataHolder<out T> private constructor(val status: RepositoryStatus, val data: T?, val error: NesineError?) {

    companion object {

        fun <T> success(data: T): DataHolder<T> {
            return DataHolder(RepositoryStatus.OK, data, null)
        }

        fun <T> error(error: NesineError, data: T?): DataHolder<T> {
            return DataHolder(RepositoryStatus.ERROR, data, error)
        }

        fun <T> loading(): DataHolder<T> {
            return DataHolder(RepositoryStatus.LOADING, null, null)
        }
    }
}
