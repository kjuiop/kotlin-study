package com.gig.lec10

/**
 * @author : JAKE
 * @date : 25. 6. 21.
 */
class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~~")
    }
}
