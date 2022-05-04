@file:JsModule("jshashes")
@file:JsNonModule
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS"
)

package jshashes

open external class JSHashes {
    open fun hex(input: String): String
    open fun b64(input: String): String
    open fun any(input: String, encoding: String): String
    open fun hex_hmac(key: String, input: String): String
    open fun b64_hmac(key: String, input: String): String
    open fun any_hmac(key: String, input: String, encoding: String): String
    open fun vm_test(): JSHashes /* this */
    open fun setUpperCase(isEnabled: Boolean): JSHashes /* this */
    open fun setPad(pad: String): JSHashes /* this */
    open fun setUTF8(isEnabled: Boolean): JSHashes /* this */
}