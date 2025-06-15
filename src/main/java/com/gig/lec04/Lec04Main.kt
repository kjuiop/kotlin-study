package com.gig.lec04

fun main() {

    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    if (money1 > money2) {
        println("Money1 이 Money2 보다 금액이 큽니다")
    }

    val money3 = JavaMoney(1_000L)
    val money4 = money3
    val money5 = JavaMoney(1_000L)

    // 값이 같은지
    println(money3 == money4)

    // 주소가 같은지
    println(money3 === money5)


    val money6 = JavaMoney(1_000L)
    val money7 = JavaMoney(2_000L)
    println(money6 + money7)
}
