package ru.sber.generics

// 1.
fun <A,B> compare(p1: Pair<A,B> , p2: Pair<A,B>): Boolean {

    return p1 == p2
}

// 2.

fun <T> countGreaterThan(anArray: Array<T>, elem: T): Int  where T : Comparable<T> {

    return anArray.toList().stream().filter{it > elem}.count().toInt()
}

// 3.
class Sorter<T> where T : Comparable<T> {
    val list: MutableList <T> = mutableListOf()

    fun add(value: T) {
        list.add(value)
        list.sort()
    }
}

// 4.
class Stack <T> {
    val stack : MutableList<T> = mutableListOf()

    fun isEmpty(): Boolean {
        return stack.size == 0
    }

    fun  push (value : T) {
        stack.add(value)
    }

    fun  pop () : T {
       return stack.removeLast()
    }
}