package com.github.zvernam.url

import kotlin.test.Test
import kotlin.test.assertEquals

class UrlComponentTest {

    @Test
    fun testEmpty() = assertAll(
        arrayOf(
            "" to "",
            " " to "%20",
            "  " to "%20%20"
        )
    )

    @Test
    fun testUnchanged() = assertAll(
        arrayOf(
            "abcdefghijklmnopqrstwxyz" to "abcdefghijklmnopqrstwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" to "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789" to "0123456789",
            ".-*_" to ".-*_"
        )
    )

    @Test
    fun testSpecial() = assertAll(
        arrayOf(
            "=" to "%3D",
            "?" to "%3F",
            "&" to "%26",
            "+" to "%2B",
        )
    )


    private fun assertEncode(source: String, expected: String) =
        assertEquals(expected, UrlComponent.encode(source), "encode")


    private fun assertAll(pairs: Array<Pair<String, String>>) =
        pairs.forEach { assertEncode(it.first, it.second) }


}