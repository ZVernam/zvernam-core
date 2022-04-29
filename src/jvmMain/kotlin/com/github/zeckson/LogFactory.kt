package com.github.zeckson

class JavaLogger(private val name: String) : Logger {
    override fun verbose(message: String) {
        // TODO: improve logging for java
        println("$name: $message")
    }
}

actual object LogFactory {
    actual fun create(name: String): Logger = JavaLogger(name)
}