package com.threeroid.threeroid.math

import org.junit.jupiter.api.Test

import org.junit.Assert.*

class Vector3Test {

    @Test
    fun target_equalities() {
        val target1 = Vector3()
        val target2 = Vector3(0.0f, 0.0f, 0.0f)
        val target3 = Vector3(0, 0, 0)
        assertTrue(target1.equals(target2))
        assertTrue(target2.equals(target3))
    }

    @Test
    fun scalar_equalities() {
        val target1 = Vector3()
        val target2 = Vector3()
        target1.setScalar(2.0f)
        target2.set(2.0f, 2.0f, 2.0f)
        assertTrue(target1.equals(target2))
    }

}
