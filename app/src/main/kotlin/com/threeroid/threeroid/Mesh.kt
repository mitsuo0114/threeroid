package com.threeroid.threeroid
import com.threeroid.threeroid.math.Vector3

class Mesh(var geometry: BoxGeometry, var material: MeshNormalMaterial) {
    val rotation = Vector3()
    val position = Vector3()

    fun draw() {
        this.geometry.draw(this.position)
    }
}
