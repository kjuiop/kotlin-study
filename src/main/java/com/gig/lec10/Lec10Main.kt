package com.gig.lec10

/**
 * @author : JAKE
 * @date : 25. 6. 21.
 */
fun main() {
    Derived(300)
}

open class Base(
    open val number: Int = 100
) {
    init {
        println("Base Class")
        println(number)
    }
}

class Derived(
    override val number: Int
) : Base(number) {

    init {
        println("Derived Class")
        println(number)
    }
}