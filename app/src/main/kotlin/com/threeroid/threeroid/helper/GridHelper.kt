package com.threeroid.threeroid.helper

import com.threeroid.threeroid.LineSegments
import com.threeroid.threeroid.materials.MeshNormalMaterial
import com.threeroid.threeroid.math.Vector3
import com.threeroid.threeroid.objects.Mesh

class GridHelper(size: Int, divisions: Int, color1: Int = 0x444444, color2: Int = 0x888888) :
    Mesh(GridHelper.computeLineDistances(size, divisions), MeshNormalMaterial()) {

    companion object {
        fun computeLineDistances(size: Int, divisions: Int): LineSegments {
            val center = divisions / 2
            val step = size / divisions
            val halfSize = size / 2

            val lineSegment =  LineSegments()

            lineSegment.addDistance(Vector3(halfSize.toFloat(), 0f, 0f),
                                    Vector3(-halfSize.toFloat(), 0f, 0f))

            return lineSegment
        }
    }

}