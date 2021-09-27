package ru.sber.functional

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PowFactoryTest {
    @Test
    fun `buildPowFunction should return lambda It should calculate to second power`() {
    //     expect
         assertEquals(9, PowFactory.buildPowFunction(2)(3))
    }

    @Test
    fun `filterByPredicate `() {
        //  expect
        val studentGroup = StudentsGroup()
        studentGroup.init()
        assertEquals(3, studentGroup.filterByPredicate({s -> s.age == 20}).size)
    }
}
