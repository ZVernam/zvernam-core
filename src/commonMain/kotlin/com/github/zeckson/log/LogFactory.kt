package com.github.zeckson.log

expect object LogFactory {
    fun create(name: String): Logger
}