package com.github.zeckson.url

import kotlin.test.Test
import kotlin.test.assertEquals

class QueryStringTest {


    @Test
    fun empty() {
        assertParse("")
        assertParse("&")
        assertParse("&&&")
    }

    @Test
    fun onePair() {
        assertParse("abc=def", "abc" to "def")
        assertParse("abc", "abc" to "")
        assertParse("=", "" to "")
        assertParse("==", "" to "=")
        assertParse("===", "" to "==")
    }

    @Test
    fun twoPairs() {
        assertParse("abc=def&two=three", "abc" to "def", "two" to "three")
        assertParse("1&2", "1" to "", "2" to "")
        assertParse("1&2=-1", "1" to "", "2" to "-1")
    }

    @Test
    fun duplicates() {
        assertParse("abc=def&abc=efd", "abc" to "efd")
    }

    @Test
    fun decode() {
        assertParse("a%20c=e+d", "a c" to "e d")
    }

    private fun assertParse(source: String, vararg pairs: Pair<String, String>) =
        assertEquals(
            if (pairs.isNotEmpty()) pairs.toMap(LinkedHashMap(pairs.size)) else emptyMap(),
            QueryString.parse(source),
            "Source: $source"
        )
}