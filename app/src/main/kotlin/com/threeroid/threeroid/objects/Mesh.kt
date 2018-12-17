package com.threeroid.threeroid.objects
import com.threeroid.threeroid.BoxGeometry
import com.threeroid.threeroid.materials.MeshNormalMaterial
import com.threeroid.threeroid.math.Vector3

class Mesh(var geometry: BoxGeometry, var material: MeshNormalMaterial) {
    val rotation = Vector3()
    val position = Vector3()

    fun draw() {
        this.geometry.draw(this.position, this.rotation)
    }
}
