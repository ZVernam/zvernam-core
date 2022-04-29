package com.github.zeckson.url

import java.net.URLDecoder
import java.net.URLEncoder

// TODO: URL encoder and URI encoder are not similar in space encoding
actual object UrlComponent {
    actual fun encode(source: String): String = URLEncoder.encode(source, Charsets.UTF_8)

    actual fun decode(source: String): String = URLDecoder.decode(source, Charsets.UTF_8)
}