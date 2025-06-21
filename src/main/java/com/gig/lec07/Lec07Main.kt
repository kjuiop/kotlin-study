package com.gig.lec07

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

/**
 * @author : JAKE
 * @date : 2025/06/21
 */
fun main() {
    val printer = FilePrinter()
    printer.readFile()
}

fun parseIntOrThrow1(str : String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 $str 는 숫자가 아닙니다.")
    }
}

fun parseIntOrThrow2(str : String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}