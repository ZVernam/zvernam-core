package com.github.zeckson.log

actual object LogFactory {
    actual fun create(name: String): Logger = JavaLogger(name)
}