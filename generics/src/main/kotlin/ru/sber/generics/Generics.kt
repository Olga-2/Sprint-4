package ru.sber.generics

import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.*

// 1.
fun  compare(p1: Pair<Any, Any> , p2: Pair<Any, Any>): Boolean {

    return (p1 == p2) || (p1.first.equals(p2.first) && (p1.second.equals(p2.second)))
}

// 2.
fun <T> countGreaterThan(anArray: Array<Comparable<T>>, elem: T): Int {

    return anArray.toList().stream().filter{it > elem}.count().toInt()
}

// 3.
class Sorter<T> {
    val list: MutableList <Comparable<T>> = mutableListOf()

    fun add(value: Comparable<T>) {
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