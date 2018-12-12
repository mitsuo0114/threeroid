package com.threeroid.threeroid

import android.opengl.GLES31
import android.opengl.GLSurfaceView
import java.nio.ByteBuffer
import java.nio.ByteOrder

import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class MyRenderer : GLSurfaceView.Renderer {

    var drawCallback: (() -> Unit)? = null
    override fun onDrawFrame(unused: GL10) {
        GLES31.glClear(GLES31.GL_COLOR_BUFFER_BIT or GLES31.GL_DEPTH_BUFFER_BIT)
        drawCallback?.invoke()
    }

    override fun onSurfaceChanged(unused: GL10, width: Int, height: Int) {
        GLES31.glViewport(0, 0, width, height)
        GLES.screenW = width
        GLES.screenH = height
    }

    override fun onSurfaceCreated(unused: GL10, unused_: EGLConfig) {
        //プログラムの生成
        GLES.makeProgram()

        GLES31.glClearColor(1.0f, 1.0f, 1.0f, 1.0f)
        GLES31.glDisable(GLES31.GL_DITHER)
        GLES31.glDisable(GLES31.GL_DEPTH_TEST)
        GLES31.glEnable(GLES31.GL_BLEND)
        GLES31.glBlendFunc(GLES31.GL_SRC_ALPHA, GLES31.GL_ONE_MINUS_SRC_ALPHA)
    }
}
