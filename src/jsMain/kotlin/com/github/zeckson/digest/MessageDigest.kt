package com.github.zeckson.digest

// TODO: implement with jshashes lib
class HashesDigest : Digest {
    override fun digest(input: ByteArray): ByteArray {
        TODO("Not yet implemented")
    }

    override fun digestToBase64(input: String): String {
        TODO("Not yet implemented")
    }
}

actual object MessageDigest {
    actual fun getInstance(algoName: Algorithm): Digest {
        return HashesDigest()
    }
}