package com.gig.lec06

/**
 * @author : JAKE
 * @date : 2025/06/21
 */
fun main() {
    printForEach()
    printTraditionalFor()
}

fun printForEach() {
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println(number)
    }
}

fun printTraditionalFor() {
    for ( i in 1..3) {
        println(i)
    }
}

fun printTraditionalForDownTo() {
    for ( i in 3 downTo 1) {
        println(i)
    }
}

fun printTraditionalForStep() {
    for ( i in 1..5 step 2) {
        println(i)
    }
}