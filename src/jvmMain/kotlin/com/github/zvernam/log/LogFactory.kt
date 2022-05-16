package com.github.zvernam.log

actual object LogFactory {
    actual fun create(name: String): Logger = JavaLogger(name)
}