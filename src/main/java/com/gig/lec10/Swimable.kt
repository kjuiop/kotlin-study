package com.gig.lec10

/**
  * @author : JAKE
  * @date : 25. 6. 21.
*/
interface Swimable {

    val swimAbility: Int
        get() = 3

    fun act() {
        println("어푸 어푸")
    }
}