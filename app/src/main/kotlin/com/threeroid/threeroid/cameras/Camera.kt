package com.threeroid.threeroid.cameras

import com.threeroid.threeroid.math.Matrix4

open class Camera() {
    var matrixWorldInverse = Matrix4()
    var projectionMatrix= Matrix4()
    var projectionMatrixInverse = Matrix4()


}