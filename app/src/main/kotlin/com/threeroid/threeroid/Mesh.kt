package com.threeroid.threeroid

class Mesh(var geometry: BoxGeometry, var material: MeshNormalMaterial) {
    val rotation = Point()
    val position = Point()

    fun draw() {
        this.geometry.draw(this.position)
    }
}
