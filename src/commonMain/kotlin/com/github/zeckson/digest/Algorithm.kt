package com.github.zeckson.digest

enum class Algorithm(val algorithm: String) {
    MD5("MD5"),
    SHA1("SHA-1"),
    SHA256("SHA-256"),
    SHA512("SHA-512");

    companion object {
        fun getByName(name: String): Algorithm =
            values()
                .find { it.algorithm == name }
                ?: throw IllegalArgumentException("$name not found")

    }
}
