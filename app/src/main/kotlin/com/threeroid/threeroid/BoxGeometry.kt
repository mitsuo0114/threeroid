package com.threeroid.threeroid

import java.nio.ByteBuffer
import android.opengl.GLES31
import java.nio.ByteOrder
import com.threeroid.threeroid.math.Vector3


class BoxGeometry(var width: Float, var height: Float, var depth: Float) {
    val line_mode = GLES31.GL_TRIANGLE_FAN

    fun floatArray(position : Vector3) : FloatArray{
        return floatArrayOf(
            position.x, position.y, position.z,
            position.x, position.y + this.width, position.z,
            position.x + this.height, position.y + this.width, position.z,
            position.x + this.height, position.y, position.z)
    }

    fun draw(position : Vector3, rotation: Vector3) {
        val line_color = floatArrayOf(0.0f, 0.0f, 0.0f, 1.0f)
        val vertices = this.floatArray(position)
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
        GLES31.glDrawArrays(line_mode, 0, vertices.size / 3)
        GLES31.glDisableVertexAttribArray(GLES.colorHandle)
        GLES31.glDisableVertexAttribArray(GLES.positionHandle)
    }

}
