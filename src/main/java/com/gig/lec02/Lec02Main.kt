package com.gig.lec02

import java.lang.IllegalArgumentException

/**
 * @author : JAKE
 * @date : 2025/06/15
 */
fun main() {
    var person = Person(null)
    println(startsWithA4(person.name))
}

fun startsWithA1(str : String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("str is null")
}

fun startsWithA2(str : String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3(str : String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun startsWith(str: String?): Boolean {
    return str!!.startsWith("A")
}

fun startsWithA4(str: String): Boolean {
    return str.startsWith("A")
}
