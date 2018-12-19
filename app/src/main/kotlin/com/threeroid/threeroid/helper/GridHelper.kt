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
            var halfSize = 0.2f // size / 2

            val lineSegment = LineSegments()
            var i = 0
            var k = 0f
//            halfSize = 0.2f
            val y = -1.0f
//            k = -halfSize
            for (i in -10..10) {
//                vertices.push( - halfSize, 0, k, halfSize, 0, k );
                lineSegment.addDistance(
                    Vector3(halfSize*i, y, 0f),
//                    Vector3(halfSize, 0, k)
                    Vector3(0f, 0f, 0f)
                )
//                k += step
            }
            for (i in -10..10) {
//                vertices.push( k, 0, - halfSize, k, 0, halfSize );
                lineSegment.addDistance(
//                    Vector3(halfSize*i, y, 0f),
                    Vector3(0f, y, halfSize*i),
                    Vector3(0f, 0f, 0f)
//                    Vector3(k, 0, halfSize)
                )
//                k += step
            }

            return lineSegment
        }
    }
}