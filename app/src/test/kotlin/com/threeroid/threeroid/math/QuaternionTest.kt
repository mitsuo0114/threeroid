package com.threeroid.threeroid.math

import org.junit.jupiter.api.Test

import org.junit.Assert.assertTrue

class QuaternionTest {

    @Test
    fun instancing() {
        var target = Quaternion()
        assertTrue(target.x == 0.0f)
        assertTrue(target.y == 0.0f)
        assertTrue(target.z == 0.0f)
        assertTrue(target.w == 1.0f)

        target = Quaternion(1.0f, 2.0f, 3.0f, 4.0f)
        assertTrue(target.x == 1.0f)
        assertTrue(target.y == 2.0f)
        assertTrue(target.z == 3.0f)
        assertTrue(target.w == 4.0f)
    }
}
