package com.threeroid.threeroid

import com.threeroid.threeroid.objects.Mesh

class Scene {
    val children = mutableListOf<Mesh>()
    fun add(box: Mesh) {
        children.add(box)
    }
}