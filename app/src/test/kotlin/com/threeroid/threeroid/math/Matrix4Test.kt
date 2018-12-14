package com.threeroid.threeroid.math

import org.junit.jupiter.api.Test

import org.junit.Assert.*

class Matrix4Test {

    @Test
    fun initiate() {
        val target1 = Matrix4()

        assertTrue(target1.elements[0] == 1)
    }

    @Test
    fun set() {
        var target1 = Matrix4()

        target1.set(
            0, 1, 2, 3,
            4, 5, 6, 7,
            8, 9, 10, 11,
            12, 13, 14, 15
        )

        assertTrue(target1.elements[0] == 0)
        assertTrue(target1.elements[1] == 4)
        assertTrue(target1.elements[2] == 8)
        assertTrue(target1.elements[3] == 12)
        assertTrue(target1.elements[4] == 1)
        assertTrue(target1.elements[5] == 5)
        assertTrue(target1.elements[6] == 9)
        assertTrue(target1.elements[7] == 13)
        assertTrue(target1.elements[8] == 2)
        assertTrue(target1.elements[9] == 6)
        assertTrue(target1.elements[10] == 10)
        assertTrue(target1.elements[11] == 14)
        assertTrue(target1.elements[12] == 3)
        assertTrue(target1.elements[13] == 7)
        assertTrue(target1.elements[14] == 11)
        assertTrue(target1.elements[15] == 15)

    }

}
