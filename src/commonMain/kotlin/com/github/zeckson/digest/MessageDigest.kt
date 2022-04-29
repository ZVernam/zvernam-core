package com.github.zeckson.digest

expect object MessageDigest {
    fun getInstance(algoName: Algorithm): Digest
}