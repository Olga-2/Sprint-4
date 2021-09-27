package ru.sber.functional

object PowFactory {
    /**
     * Возвращает функцию, которая всегда возводит аргумент в нужную степень, указанную при создании функции.
     */
    fun buildPowFunction(pow: Int) = {

        b : Int -> Math.pow(b.toDouble(), pow.toDouble()).toInt()
    }
}
