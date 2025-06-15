package com.gig.lec03

fun main() {
    printAgeIfPerson4(Person("jake", 100))

    val str = """
        ABCD
        EFG
    """.trimIndent()
    println(str)
}

fun printAgeIfPerson1(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
        println(person.age)
    }
}

fun printAgeIfPerson2(obj: Any) {
    if (obj is Person) {
        println(obj.age)
    }
}

fun printAgeIfPerson3(obj: Any) {
    if (obj !is Person) {
    }
}

fun printAgeIfPerson4(obj: Any?) {
    val person = obj as? Person
    println(person?.age)
}