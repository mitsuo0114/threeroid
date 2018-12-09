package com.threeroid.threeroid

class Scene {
    val objects = mutableListOf<Mesh>()
    fun add(box: Mesh) {
        objects.add(box)
    }

}