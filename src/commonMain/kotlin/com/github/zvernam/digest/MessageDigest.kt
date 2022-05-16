package com.github.zvernam.digest

expect object MessageDigest {
    fun getInstance(algoName: Algorithm): Digest
}