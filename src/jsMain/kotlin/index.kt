@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

import com.github.zvernam.VernamUtils

@OptIn(ExperimentalJsExport::class)
@JsExport
fun encrypt(text: String, secret: String) = VernamUtils.encrypt(text, secret)

@OptIn(ExperimentalJsExport::class)
@JsExport
fun hash(text: String, algoName: String = "SHA-256") = VernamUtils.hash(text, algoName)
