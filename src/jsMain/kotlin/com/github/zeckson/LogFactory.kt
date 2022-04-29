package com.github.zeckson

class JsLogger(private val name: String): Logger {
    override fun verbose(message: String) {
        console.log("$name: $message")
    }
}

actual object LogFactory {
    actual fun create(name: String): Logger = JsLogger(name)
}