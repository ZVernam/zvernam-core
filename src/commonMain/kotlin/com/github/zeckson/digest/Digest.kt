package com.github.zeckson.digest

interface Digest {
    fun digest(input: ByteArray): ByteArray
    fun digestToBase64(input: String): String
}