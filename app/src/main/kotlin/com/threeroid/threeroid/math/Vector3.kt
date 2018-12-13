package com.threeroid.threeroid.math

/**
 * https://github.com/mrdoob/three.js/blob/dev/src/math/Vector3.js
 */
data class Vector3(var x: Float = 0.0f, var y: Float = 0.0f, var z: Float = 0.0f) {
    constructor(x: Int, y: Int, z: Int) : this(x.toFloat(), y.toFloat(), z.toFloat())

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
}
