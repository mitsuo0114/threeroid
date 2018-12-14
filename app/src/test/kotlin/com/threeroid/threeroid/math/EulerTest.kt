package com.threeroid.threeroid.math

import org.junit.jupiter.api.Test

import org.junit.Assert.*

class EulerTest {

    @Test
    fun instancing() {
        var target = Euler()
        assertTrue(target.x == 0.0f)
        assertTrue(target.y == 0.0f)
        assertTrue(target.z == 0.0f)
        assertTrue(target.order == "XYZ")

        target = Euler(1.0f, 2.0f, 3.0f)
        assertTrue(target.x == 1.0f)
        assertTrue(target.y == 2.0f)
        assertTrue(target.z == 3.0f)
        assertTrue(target.order == "XYZ")
    }

    @Test
    fun equalities() {
        val target1 = Euler()
        val target2 = Euler(0.0f, 1.0f, 0.0f, "ZYX")
        val vec = Vector3(0.0f, 1.0f, 0.0f)
        val target3 = Euler(vec, "ZYX")

        assertFalse(target1.equals(target2))
        assertTrue(target2.equals(target3))
        assertTrue(vec.equals(target3.toVector3()))
    }

}
