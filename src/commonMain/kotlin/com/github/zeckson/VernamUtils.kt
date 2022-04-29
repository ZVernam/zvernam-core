package com.github.zeckson

import com.github.zeckson.digest.Algorithm
import com.github.zeckson.digest.Digest
import com.github.zeckson.digest.MessageDigest
import com.github.zeckson.log.LogFactory

class VernamUtils {
    companion object {
        private val LOGGER = LogFactory.create("VernamUtils")
        private val ALPHABET = "@bCd3f9h1jKlm2nN0pq4r\$tuv5wW6x7y8Zz".toCharArray()

        fun encrypt(text: String, secret: String): String {
            // Failfast
            if (text.isBlank() || secret.isBlank()) {
                return ""
            }

            val cipher = CharArray(text.length)
            for (i in text.indices) {
                val left = text[i]
                val right = secret[i % secret.length]
                val result = left.code xor right.code
                cipher[i] = toChar(result)
            }
            return cipher.joinToString("")
        }

        /**
         * Hashes provided input by default with `SHA-256`, converts to `Base64`
         * and trims to source string length by default
         * @param {String} text — text to hash
         * @param {String} [algoName=`SHA-256`] — hash algorithm name
         * @return {string}
         */
        fun hash(text: String, algoName: String = "SHA-256"): String {
            if (text.isBlank()) {
                return text
            }

            val algo = Algorithm.getByName(algoName)

            val digest: Digest = MessageDigest.getInstance(algo)
            val value = digest.digestToBase64(text)

            LOGGER.verbose("Using hash-algorithm: $algoName")
            LOGGER.verbose("Hash Output b64: $value")

            return value
        }

        private fun toChar(code: Int): Char = ALPHABET[code % ALPHABET.size]

    }
}