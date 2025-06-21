package com.gig.lec05

import java.lang.IllegalArgumentException

/**
 * @author : JAKE
 * @date : 2025/06/21
 */
fun main() {

}

// void 생략됨
fun validateScoreIsNotNegative(score: Int) {
    if (score !in 0..100) {
        throw IllegalArgumentException("$score 의 범위는 0부터 100입니다.")
    }
}

fun getPassOrFail(score: Int): String {
    // kotlin 에서 if 문은 문장이 아닌 값이기 때문에 반환 값으로도 사용할 수 있다.
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

fun getGradeWithWhen(score: Int): String {
    return when (score / 100) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

fun getGradeWithWhenIn(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber1(number: Int) {
    when (number) {
        1, 0, -1 -> println("1, 0, -1 중 하나의 숫자입니다.")
        else -> println("1, 0, -1 이 모두 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0 입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다.")
    }
}