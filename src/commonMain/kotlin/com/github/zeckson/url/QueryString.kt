package com.github.zeckson.url

const val PAIR_DELIMITER = '&'
const val KEY_VALUE_DELIMITER = '='

object QueryString {
    /**
     * Parses query string to parameters map
     *
     * For details @see QueryStringTest
     */
    fun parse(source: String): Map<String, String> {
        val map = HashMap<String, String>()
        if (source.isBlank()) return map

        val pairs = source.split(PAIR_DELIMITER)
        for (pair in pairs) {
            if (pair.isEmpty()) continue
            val (key, value) = pair.split(KEY_VALUE_DELIMITER).let { when (it.size) {
                1 -> it[0] to ""
                2 -> it[0] to it[1]
                else -> throw IllegalStateException("Invalid key/value: $pair")
            }}
                map[UrlComponent.decode(key)] = UrlComponent.decode(value)
        }
        return map
    }
}