package com.gig.lec11

/**
 * @author : JAKE
 * @date : 25. 6. 22.
 */
class Car (
    internal val name: String,
    private var owner: String,
    _price: Int
) {
    var price = _price
        private set
}