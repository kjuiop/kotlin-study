package com.gig.lec08

/**
 * @author : JAKE
 * @date : 2025/06/21
 */
fun main() {
    repeat("Hello World", useNewLine = false)

    val array = arrayOf("A", "B", "C")
    printAll(*array)
}

fun max1(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun max2(a: Int, b: Int): Int =
    if (a > b) {
        a
    } else {
        b
    }

fun max3(a: Int, b: Int): Int = if (a > b) a else b


fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}