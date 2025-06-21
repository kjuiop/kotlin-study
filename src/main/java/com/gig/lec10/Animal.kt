package com.gig.lec10

/**
 * @author : JAKE
 * @date : 25. 6. 21.
 */
abstract class Animal (
    protected val species: String,
    protected open val legCount: Int
) {
    abstract fun move()
}