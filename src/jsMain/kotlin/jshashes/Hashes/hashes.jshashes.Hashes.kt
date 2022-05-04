@file:JsModule("jshashes")
@file:JsNonModule
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jshashes.Hashes

import jshashes.JSHashes

open external class MD5 : JSHashes

open external class SHA1 : JSHashes

open external class SHA256 : JSHashes

open external class SHA512 : JSHashes

open external class RMD160 : JSHashes