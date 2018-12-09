package com.threeroid.threeroid

class Scene {
    val children = mutableListOf<Mesh>()
    fun add(box: Mesh) {
        children.add(box)
    }

}