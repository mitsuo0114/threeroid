package com.threeroid.threeroid.math

import org.junit.jupiter.api.Test

import org.junit.Assert.*

class Vector3Test {

    @Test
    fun equalities() {
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

    @Test
    fun add() {
        val target1 = Vector3(0.0f, 0.0f, 0.0f)
        val target2 = Vector3(1.0f, 2.0f, 3.0f)

        target1.add(target2)

        assertTrue(target1.x == 1.0f)
        assertTrue(target1.y == 2.0f)
        assertTrue(target1.z == 3.0f)
    }

    @Test
    fun addScaledVector() {
        val target1 = Vector3(0.0f, 0.0f, 0.0f)
        val target2 = Vector3(1.0f, 2.0f, 3.0f)

        target1.addScaledVector(target2, 4.0f)

        assertTrue(target1.x == 4.0f)
        assertTrue(target1.y == 8.0f)
        assertTrue(target1.z == 12.0f)
    }

    @Test
    fun multiplyVectors() {
        val target1 = Vector3(4.0f, 4.0f, 4.0f)
        val target2 = Vector3(1.0f, 2.0f, 3.0f)

        val result = Vector3.multiplyVectors(target1, target2)

        assertTrue(result.x == 4.0f)
        assertTrue(result.y == 8.0f)
        assertTrue(result.z == 12.0f)
    }

}
