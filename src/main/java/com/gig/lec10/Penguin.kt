package com.gig.lec10

/**
 * @author : JAKE
 * @date : 25. 6. 21.
 */
class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    constructor(species: String, wingCount: Int) : this(species)

    override fun move() {
        println("펭귄이 뒤뚱뒤뚱 걸어가~~")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

    override val swimAbility: Int
        get() = 3
}