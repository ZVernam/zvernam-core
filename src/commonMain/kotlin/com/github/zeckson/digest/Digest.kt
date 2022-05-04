package com.github.zeckson.digest

interface Digest {
    fun digestToBase64(input: String): String
}