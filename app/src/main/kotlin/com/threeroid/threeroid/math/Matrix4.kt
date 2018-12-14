package com.threeroid.threeroid.math

/**
 * https://github.com/mrdoob/three.js/blob/dev/src/math/Matrix4.js
 */
class Matrix4 {

    val elements = arrayOf(
        1, 0, 0, 0,
        0, 1, 0, 0,
        0, 0, 1, 0,
        0, 0, 0, 1
    )

    fun set(
        n11: Int, n12: Int, n13: Int, n14: Int,
        n21: Int, n22: Int, n23: Int, n24: Int,
        n31: Int, n32: Int, n33: Int, n34: Int,
        n41: Int, n42: Int, n43: Int, n44: Int
    ): Matrix4 {
        val te = this.elements

        te[0] = n11; te[4] = n12; te[8] = n13; te[12] = n14
        te[1] = n21; te[5] = n22; te[9] = n23; te[13] = n24
        te[2] = n31; te[6] = n32; te[10] = n33; te[14] = n34
        te[3] = n41; te[7] = n42; te[11] = n43; te[15] = n44

        return this
    }

}