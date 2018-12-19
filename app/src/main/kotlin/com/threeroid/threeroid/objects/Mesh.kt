package com.threeroid.threeroid.objects
import com.threeroid.threeroid.BufferGeometry
import com.threeroid.threeroid.materials.MeshNormalMaterial
import com.threeroid.threeroid.math.Vector3

open class Mesh(var geometry: BufferGeometry, var material: MeshNormalMaterial) {

    val rotation = Vector3()
    val position = Vector3()

    fun draw() {
        this.geometry.draw(this.position, this.rotation)
    }
}
