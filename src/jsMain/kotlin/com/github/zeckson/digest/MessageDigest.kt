package com.github.zeckson.digest

import jshashes.Hashes.MD5
import jshashes.Hashes.SHA1
import jshashes.Hashes.SHA256
import jshashes.Hashes.SHA512
import jshashes.JSHashes

fun getJSHashes(algorithm: Algorithm): JSHashes {
    val hash = when (algorithm) {
        Algorithm.MD5 -> MD5()
        Algorithm.SHA1 -> SHA1()
        Algorithm.SHA256 -> SHA256()
        Algorithm.SHA512 -> SHA512()
    }
    return hash
}

class HashesDigest(private val hashAlgo: JSHashes) : Digest {
    override fun digestToBase64(input: String): String {
        return hashAlgo.b64(input)
    }
}

actual object MessageDigest {
    actual fun getInstance(algoName: Algorithm): Digest {
        return HashesDigest(getJSHashes(algoName))
    }
}