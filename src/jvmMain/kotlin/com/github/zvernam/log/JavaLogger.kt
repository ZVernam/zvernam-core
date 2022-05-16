package com.github.zvernam.log

class JavaLogger(private val name: String) : Logger {
    override fun verbose(message: String) {
        // TODO: improve logging for java/android
        println("$name: $message")
    }
}

