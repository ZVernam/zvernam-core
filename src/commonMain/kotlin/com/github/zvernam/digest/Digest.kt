package com.github.zvernam.digest

interface Digest {
    fun digestToBase64(input: String): String
}