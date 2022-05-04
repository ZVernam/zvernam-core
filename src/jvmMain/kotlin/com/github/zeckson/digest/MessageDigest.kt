package com.github.zeckson.digest

import java.security.MessageDigest
import java.util.*

class JavaDigest(private val digest: MessageDigest) : Digest {
    override fun digestToBase64(input: String): String {
        val bytes = digest.digest(input.toByteArray(Charsets.UTF_8))
        return Base64.getEncoder().encodeToString(bytes)
    }
}

actual object MessageDigest {
    actual fun getInstance(algoName: Algorithm): Digest = JavaDigest(MessageDigest.getInstance(algoName.algorithm))
}