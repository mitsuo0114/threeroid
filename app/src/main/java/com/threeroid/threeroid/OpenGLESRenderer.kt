package com.threeroid.threeroid

import android.opengl.GLES31
import android.opengl.GLSurfaceView
import java.nio.ByteBuffer
import java.nio.ByteOrder

class OpenGLESRenderer(val canvas: GLSurfaceView, val myRenderer: MyRenderer) {
    fun setRenderLoop(function: () -> Unit) {

    }

    fun render(scene: Scene, camera: PerspectiveCamera) {
        myRenderer.drawCallback = fun() {
            scene.children.forEach {
                it.draw()
            }
        }
    }

    init {
        canvas.setRenderer(myRenderer)
    }

}