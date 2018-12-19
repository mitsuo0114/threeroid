package com.threeroid.threeroid.math

import org.junit.jupiter.api.Test

import org.junit.Assert.assertTrue

class Matrix4Test {

    @Test
    fun initiate() {
        val target1 = Matrix4()

        assertTrue(target1.elements[0] == 1f)
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

        assertTrue(target1.elements[0] == 0f)
        assertTrue(target1.elements[1] == 4f)
        assertTrue(target1.elements[2] == 8f)
        assertTrue(target1.elements[3] == 12f)
        assertTrue(target1.elements[4] == 1f)
        assertTrue(target1.elements[5] == 5f)
        assertTrue(target1.elements[6] == 9f)
        assertTrue(target1.elements[7] == 13f)
        assertTrue(target1.elements[8] == 2f)
        assertTrue(target1.elements[9] == 6f)
        assertTrue(target1.elements[10] == 10f)
        assertTrue(target1.elements[11] == 14f)
        assertTrue(target1.elements[12] == 3f)
        assertTrue(target1.elements[13] == 7f)
        assertTrue(target1.elements[14] == 11f)
        assertTrue(target1.elements[15] == 15f)
    }
}
