package com.threeroid.threeroid

import android.opengl.GLES31
import com.threeroid.threeroid.math.Vector3
import java.nio.ByteBuffer
import java.nio.ByteOrder

class LineSegments() : BufferGeometry {
    val lineDistances = mutableListOf<Vector3>()

    fun addDistance(v1: Vector3, v2: Vector3) {
        lineDistances.add(v1)
        lineDistances.add(v2)
    }

    fun floatArray(): FloatArray {
        val tmp = mutableListOf<Float>()
        for (line in lineDistances) {
            tmp.add(line.x)
            tmp.add(line.y)
            tmp.add(line.z)
        }
        return tmp.toFloatArray()
    }


    override fun draw(position: Vector3, rotation: Vector3) {
        val line_color = floatArrayOf(0.0f, 0.0f, 0.0f, 1.0f)
        val vertices = this.floatArray()
        GLES31.glEnableVertexAttribArray(GLES.positionHandle)
        GLES31.glEnableVertexAttribArray(GLES.colorHandle)
        GLES31.glUniform1i(GLES.texenableHandle, 0)
        GLES31.glUniform4f(GLES.colorHandle, line_color[0], line_color[1], line_color[2], line_color[3])

        var bb = ByteBuffer.allocateDirect(vertices.size * 4)
        bb.order(ByteOrder.nativeOrder())
        var vertexBuffer = bb.asFloatBuffer()
        vertexBuffer.put(vertices)
        vertexBuffer.position(0)

        GLES31.glVertexAttribPointer(GLES.positionHandle, 3, GLES31.GL_FLOAT, false, 0, vertexBuffer);
        GLES31.glDrawArrays(GLES31.GL_LINES, 0, vertices.size / 3)
        GLES31.glDisableVertexAttribArray(GLES.colorHandle)
        GLES31.glDisableVertexAttribArray(GLES.positionHandle)
    }


}