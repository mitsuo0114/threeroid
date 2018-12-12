package com.threeroid.threeroid

class Point(var x: Float = 0.0f, var y: Float = 0.0f, var z: Float = 0.0f) {

    fun set(x: Int, y: Int, z: Int) {
        this.set(x.toFloat(), y.toFloat(), z.toFloat())
    }

    fun set(x: Float, y: Float, z: Float) {
        this.x = x
        this.y = y
        this.z = z
    }


}
