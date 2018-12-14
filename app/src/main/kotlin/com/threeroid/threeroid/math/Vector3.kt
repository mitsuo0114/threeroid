package com.threeroid.threeroid.math

/**
 * https://github.com/mrdoob/three.js/blob/dev/src/math/Vector3.js
 */
data class Vector3(var x: Float = 0.0f, var y: Float = 0.0f, var z: Float = 0.0f) {
    constructor(x: Int, y: Int, z: Int) : this(x.toFloat(), y.toFloat(), z.toFloat())

    companion object {
        fun multiplyVectors(v1: Vector3, v2: Vector3): Vector3 {
            return Vector3(v1.x * v2.x, v1.y * v2.y, v1.z * v2.z)
        }
    }


    fun set(x: Float, y: Float, z: Float): Vector3 {
        this.x = x
        this.y = y
        this.z = z
        return this
    }

    fun setScalar(scalar: Float): Vector3 {
        this.x = scalar
        this.y = scalar
        this.z = scalar
        return this
    }

    fun add(other: Vector3): Vector3 {
        this.x += other.x
        this.y += other.y
        this.z += other.z
        return this
    }

    fun addScaledVector(other: Vector3, scalar: Float): Vector3 {
        this.x += other.x * scalar
        this.y += other.y * scalar
        this.z += other.z * scalar
        return this
    }


}
