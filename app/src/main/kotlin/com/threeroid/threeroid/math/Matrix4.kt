package com.threeroid.threeroid.math

/**
 * https://github.com/mrdoob/three.js/blob/dev/src/math/Matrix4.js
 */
class Matrix4 {

    val elements = arrayOf(
        1f, 0f, 0f, 0f,
        0f, 1f, 0f, 0f,
        0f, 0f, 1f, 0f,
        0f, 0f, 0f, 1f
    )

    fun set(
        n11: Float,
        n12: Float,
        n13: Float,
        n14: Float,
        n21: Float,
        n22: Float,
        n23: Float,
        n24: Float,
        n31: Float,
        n32: Float,
        n33: Float,
        n34: Float,
        n41: Float,
        n42: Float,
        n43: Float,
        n44: Float
    ): Matrix4 {
        val te = this.elements

        te[0] = n11; te[4] = n12; te[8] = n13; te[12] = n14
        te[1] = n21; te[5] = n22; te[9] = n23; te[13] = n24
        te[2] = n31; te[6] = n32; te[10] = n33; te[14] = n34
        te[3] = n41; te[7] = n42; te[11] = n43; te[15] = n44

        return this
    }

    fun set(
        n11: Int,
        n12: Int,
        n13: Int,
        n14: Int,
        n21: Int,
        n22: Int,
        n23: Int,
        n24: Int,
        n31: Int,
        n32: Int,
        n33: Int,
        n34: Int,
        n41: Int,
        n42: Int,
        n43: Int,
        n44: Int
    ): Matrix4 {
        return this.set(
            n11.toFloat(), n12.toFloat(), n13.toFloat(), n14.toFloat(),
            n21.toFloat(), n22.toFloat(), n23.toFloat(), n24.toFloat(),
            n31.toFloat(), n32.toFloat(), n33.toFloat(), n34.toFloat(),
            n41.toFloat(), n42.toFloat(), n43.toFloat(), n44.toFloat()
        )
    }

    fun makePerspective(left: Float, right: Float, top: Float, bottom: Float, near: Float, far: Float): Matrix4 {
        var te = this.elements
        var x = 2 * near / (right - left)
        var y = 2 * near / (top - bottom)

        var a = (right + left) / (right - left)
        var b = (top + bottom) / (top - bottom)
        var c = -(far + near) / (far - near)
        var d = -2 * far * near / (far - near)

        te[0] = x; te[4] = 0f; te[8] = a; te[12] = 0f
        te[1] = 0f; te[5] = y; te[9] = b; te[13] = 0f
        te[2] = 0f; te[6] = 0f; te[10] = c; te[14] = d
        te[3] = 0f; te[7] = 0f; te[11] = -1f; te[15] = 0f

        return this
    }

    fun getInverse(m: Matrix4): Matrix4 {
        var te = this.elements
        val me = m.elements

        val n11 = me[0]
        val n21 = me[1]
        val n31 = me[2]
        val n41 = me[3]
        val n12 = me[4]
        val n22 = me[5]
        val n32 = me[6]
        val n42 = me[7]
        val n13 = me[8]
        val n23 = me[9]
        val n33 = me[10]
        val n43 = me[11]
        val n14 = me[12]
        val n24 = me[13]
        val n34 = me[14]
        val n44 = me[15]

        val t11 =
            n23 * n34 * n42 - n24 * n33 * n42 + n24 * n32 * n43 - n22 * n34 * n43 - n23 * n32 * n44 + n22 * n33 * n44
        val t12 =
            n14 * n33 * n42 - n13 * n34 * n42 - n14 * n32 * n43 + n12 * n34 * n43 + n13 * n32 * n44 - n12 * n33 * n44
        val t13 =
            n13 * n24 * n42 - n14 * n23 * n42 + n14 * n22 * n43 - n12 * n24 * n43 - n13 * n22 * n44 + n12 * n23 * n44
        val t14 =
            n14 * n23 * n32 - n13 * n24 * n32 - n14 * n22 * n33 + n12 * n24 * n33 + n13 * n22 * n34 - n12 * n23 * n34

        var det = n11 * t11 + n21 * t12 + n31 * t13 + n41 * t14

        if (det == 0f) {
            return this.identity()
        } else {
            var detInv = 1 / det

            te[0] = t11 * detInv
            te[1] = (n24 * n33 * n41 - n23 * n34 * n41 - n24 * n31 * n43 + n21 * n34 * n43 + n23 * n31 * n44 - n21 * n33 * n44) *
                    detInv
            te[2] = (n22 * n34 * n41 - n24 * n32 * n41 + n24 * n31 * n42 - n21 * n34 * n42 - n22 * n31 * n44 + n21 * n32 * n44) *
                    detInv
            te[3] = (n23 * n32 * n41 - n22 * n33 * n41 - n23 * n31 * n42 + n21 * n33 * n42 + n22 * n31 * n43 - n21 * n32 * n43) *
                    detInv

            te[4] = t12 * detInv
            te[5] = (n13 * n34 * n41 - n14 * n33 * n41 + n14 * n31 * n43 - n11 * n34 * n43 - n13 * n31 * n44 + n11 * n33 * n44) *
                    detInv
            te[6] = (n14 * n32 * n41 - n12 * n34 * n41 - n14 * n31 * n42 + n11 * n34 * n42 + n12 * n31 * n44 - n11 * n32 * n44) *
                    detInv
            te[7] = (n12 * n33 * n41 - n13 * n32 * n41 + n13 * n31 * n42 - n11 * n33 * n42 - n12 * n31 * n43 + n11 * n32 * n43) *
                    detInv

            te[8] = t13 * detInv
            te[9] = (n14 * n23 * n41 - n13 * n24 * n41 - n14 * n21 * n43 + n11 * n24 * n43 + n13 * n21 * n44 - n11 * n23 * n44) *
                    detInv
            te[10] = (n12 * n24 * n41 - n14 * n22 * n41 + n14 * n21 * n42 - n11 * n24 * n42 - n12 * n21 * n44 + n11 * n22 * n44) *
                    detInv
            te[11] = (n13 * n22 * n41 - n12 * n23 * n41 - n13 * n21 * n42 + n11 * n23 * n42 + n12 * n21 * n43 - n11 * n22 * n43) *
                    detInv

            te[12] = t14 * detInv
            te[13] = (n13 * n24 * n31 - n14 * n23 * n31 + n14 * n21 * n33 - n11 * n24 * n33 - n13 * n21 * n34 + n11 * n23 * n34) *
                    detInv
            te[14] = (n14 * n22 * n31 - n12 * n24 * n31 - n14 * n21 * n32 + n11 * n24 * n32 + n12 * n21 * n34 - n11 * n22 * n34) *
                    detInv
            te[15] = (n12 * n23 * n31 - n13 * n22 * n31 + n13 * n21 * n32 - n11 * n23 * n32 - n12 * n21 * n33 + n11 * n22 * n33) *
                    detInv

            return this
        }
    }

    fun identity(): Matrix4 {

        this.set(

            1f, 0f, 0f, 0f,
            0f, 1f, 0f, 0f,
            0f, 0f, 1f, 0f,
            0f, 0f, 0f, 1f

        )

        return this
    }
}