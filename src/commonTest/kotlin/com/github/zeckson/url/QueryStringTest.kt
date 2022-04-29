package com.github.zeckson.url

import kotlin.test.Test
import kotlin.test.assertEquals

class QueryStringTest {


    @Test
    fun empty() {
        assertEquals(mapOf(), QueryString.parse(""))
        assertEquals(mapOf(), QueryString.parse("&"))
        assertEquals(mapOf(), QueryString.parse("&&&"))
    }

    @Test
    fun onePair() {
        assertEquals(mapOf("abc" to "def"), QueryString.parse("abc=def"))
        assertEquals(mapOf("abc" to ""), QueryString.parse("abc"))
        assertEquals(mapOf("" to ""), QueryString.parse("="))
    }

    @Test
    fun twoPairs() {
        assertEquals(mapOf("abc" to "def", "two" to "three"), QueryString.parse("abc=def&two=three"))
        assertEquals(mapOf("1" to "", "2" to "-1"), QueryString.parse("1&2=-1"))
        assertEquals(mapOf("1" to "", "2" to ""), QueryString.parse("1&2"))
    }

    @Test
    fun duplicates() {
        assertEquals(mapOf("abc" to "efd"), QueryString.parse("abc=def&abc=efd"))
    }
}