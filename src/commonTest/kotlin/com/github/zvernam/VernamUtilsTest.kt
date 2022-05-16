package com.github.zvernam

import kotlin.test.Test
import kotlin.test.assertEquals


class VernamUtilsTest {
    private fun assertEncode(expected: String, actual: String) {
        assertEquals(expected, actual, "Encode")
    }

    private fun encrypt(text: String, secret: String) = VernamUtils.encrypt(text, secret)

    private fun hash(text: String): String = VernamUtils.hash(text)
    private fun hash(text: String, algoName: String): String = VernamUtils.hash(text, algoName)

    @Test
    fun encodeText() {
        assertEncode("@@@@", encrypt("text", "text"))
    }

    @Test
    fun checkEmpty() {
        assertEncode("", encrypt("", ""))
        assertEncode("", encrypt("   ", ""))
        assertEncode("", encrypt("   ", "   "))
        assertEncode("", encrypt("", "   "))
        assertEncode("", encrypt("text", ""))
        assertEncode("", encrypt("", "secret"))
    }


    @Test
    fun hashWithSHA256WithB64() {
        val b64 = hash("vFniW7aivKX8sydozDmB", "SHA-256")
        assertEncode("TzHgUDhLt8j+uIahKV+X2AptjioDUronhEu5ik17UTA=", b64)
    }

    @Test
    fun checkRegressionWithDefaultHash() {
        assertEncode("C1n25Cu52\$", encrypt("abcdefghij", hash("abcdefghij")))
        assertEncode(
            "86Kl1W1dql4vN29vm056",
            encrypt("lzFT95rQGbfba5GAedoX", hash("lzFT95rQGbfba5GAedoX"))
        )
        assertEncode(
            "h00rzbb15Zwr42WmN92t",
            encrypt("OYb2Xlnc1FG5TgWZWPWi", hash("EVDM62G85RrOlJppDTpF"))
        )
        assertEncode(
            "tt@lWfjW7h662K1Wnuzn",
            encrypt("mlHINlaW5uv7xCiszlCV", hash("vFniW7aivKX8sydozDmB"))
        )
    }

    @Test
    fun checkRegressionWithSHA256() {
        assertEncode(
            "tt@lWfjW7h662K1Wnuzn",
            encrypt("mlHINlaW5uv7xCiszlCV", hash("vFniW7aivKX8sydozDmB", "SHA-256"))
        )
    }

    @Test
    fun checkRegressionWithSHA1() {
        assertEncode(
            "tt@lWfjW7h662K1Wnuzn",
            encrypt("mlHINlaW5uv7xCiszlCV", hash("vFniW7aivKX8sydozDmB", "SHA-256"))
        )
    }

    @Test
    fun checkRegressionWithMD5() {
        assertEncode(
            "N2Z34xnWlWlfCmwrnttN",
            encrypt("mlHINlaW5uv7xCiszlCV", hash("vFniW7aivKX8sydozDmB", "MD5"))
        )
    }

}