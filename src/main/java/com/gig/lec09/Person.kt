package com.gig.lec09

/**
 * @author : JAKE
 * @date : 25. 6. 21.
 */
class Person(
    name: String,
    var age: Int
) {

    var name = name
        set(value) {
            field = value.uppercase()
        }


    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 $age 일 수 없습니다.")
        }
    }

    val upperCaseName: String
        get() = this.name.uppercase()

    constructor(name: String) : this(name, 1)

    constructor(): this("제이크") {
        println("부 생성자 생성")
    }

    val isAdult: Boolean
        get() = age >= 20
}

