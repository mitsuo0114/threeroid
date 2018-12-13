package com.threeroid.threeroid

import com.threeroid.threeroid.math.Euler
import com.threeroid.threeroid.math.Quaternion
import com.threeroid.threeroid.math.Vector3


/**
 * https://github.com/mrdoob/three.js/blob/dev/src/core/Object3D.js
 */
class Object3D() {
    var position = Vector3()
    var rotation = Euler()
    var quaternion = Quaternion()
    var scale = Vector3(1, 1, 1)


}