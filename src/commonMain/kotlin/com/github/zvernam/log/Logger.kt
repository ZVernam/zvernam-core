package com.github.zvernam.log

interface Logger {
    companion object {
        const val DEBUG = 1
        const val INFO = 2
        const val WARN = 3
        const val ERROR = 4
        const val VERBOSE = 5
    }

    fun verbose(message: String)
}