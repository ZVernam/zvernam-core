package com.github.zvernam.log

class JsLogger(private val name: String) : Logger {
    override fun verbose(message: String) {
        console.log("$name: $message")
    }
}
