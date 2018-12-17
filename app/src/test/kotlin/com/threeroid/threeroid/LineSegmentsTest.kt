package com.threeroid.threeroid

import com.threeroid.threeroid.core.Object3D
import com.threeroid.threeroid.math.Vector3
import org.junit.jupiter.api.Test

class LineSegmentsTest{

    @Test
    fun create_target() {
        var target = LineSegments()
        target.addDistance(
            Vector3(1f, 2f, 3f),
            Vector3(4f, 5f, 6f)
        )
        target.addDistance(
            Vector3().setScalar(1f),
            Vector3().setScalar(2f)
        )
        assert(target.lineDistances.size ==  4)
        var arr = target.floatArray()
        assert(arr[0] == 1f)
        assert(arr[1] == 2f)
        assert(arr[2] == 3f)
        assert(arr[3] == 4f)
        assert(arr[4] == 5f)
        assert(arr[5] == 6f)
        assert(arr[6] == 1f)
    }

}