package com.jakchang.tdd_study.other

data class Resource<out T>(val status: Status, val data: T?, val messsage: String?){
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }
        fun <T> error(msg:String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }
        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}