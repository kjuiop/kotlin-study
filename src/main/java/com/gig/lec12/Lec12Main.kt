package com.gig.lec12

/**
 * @author : JAKE
 * @date : 25. 6. 22.
 */
fun main() {
    val person = Person.Factory.newBody("jake")
    println(person.name)

    println(Singleton.a)


    moveSomething(object : Movable {
        override fun move() {
            println("move")
        }
        override fun fly() {
            println("fly")
        }
    })
}

class Person private constructor (
    val name: String,
    val age: Int,
) {
    // static 대신 companion object
    companion object Factory : Log{
        // runtime 시 값이 할당됨
        // var MIN_AGE = 1

        // 컴파일 시 값이 할당 됨
        const val MIN_AGE = 1
        fun newBody(name: String) = Person(name, MIN_AGE)


        override fun log() {
            println("나는 동적 객체이다.")
        }
    }
}

object Singleton {
    var a: Int = 0
}

fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}