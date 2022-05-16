package com.github.zvernam.log

expect object LogFactory {
    fun create(name: String): Logger
}