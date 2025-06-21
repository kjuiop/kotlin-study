package com.gig.lec09

/**
 * @author : JAKE
 * @date : 25. 6. 21.
 */
fun main() {
    val person = Person("jake", 100)
    person.age = 50
    println(person.age)

    val person2 = Person("jake2")
    println(person2.age)

    val person3 = Person()
    println(person3.name)
}

