package com.github.zvernam.url

expect object UrlComponent {
    fun encode(source: String): String
    fun decode(source: String): String
}