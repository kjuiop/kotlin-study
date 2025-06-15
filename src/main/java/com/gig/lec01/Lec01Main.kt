package com.gig.lec01

/**
 * @author : JAKE
 * @date : 2025/06/15
 */
fun main() {
    // 가변
    var number1 = 10L

    // 불변
    val number2 = 10L

    // nullable
    var number3: Long? = null

    // 객체 생성
    var person = Person("사람")

    println("number1 (var): $number1")
    println("number2 (val): $number2")
    println("number3 (nullable): $number3")
    println("person: $person")
}
