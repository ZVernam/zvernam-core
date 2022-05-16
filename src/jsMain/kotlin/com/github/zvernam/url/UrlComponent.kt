package com.github.zvernam.url

val encodeUriComponent = js("encodeURIComponent").unsafeCast<(Any?) -> String>()
val decodeUriComponent = js("decodeURIComponent").unsafeCast<(Any?) -> String>()

actual object UrlComponent {
    actual fun encode(source: String): String = encodeUriComponent(source)

    actual fun decode(source: String): String = decodeUriComponent(source)
}