package com.threeroid.threeroid.math

import com.threeroid.threeroid.math.Vector3

/**
 * https://github.com/mrdoob/three.js/blob/dev/src/math/Euler.js
 */
data class Euler(var x: Float = 0.0f, var y: Float = 0.0f, var z: Float = 0.0f, var order: String = "XYZ") {
    fun toVector3(): Vector3 {
        return Vector3(this.x, this.y, this.z)
    }

    constructor(vec: Vector3, order: String) : this(vec.x, vec.y, vec.z, order)
}
