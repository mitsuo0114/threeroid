package com.threeroid.threeroid

import android.opengl.GLSurfaceView
import com.threeroid.threeroid.cameras.PerspectiveCamera

class OpenGLESRenderer(val canvas: GLSurfaceView, val myRenderer: MyRenderer) {
    fun setRenderLoop(function: () -> Unit) {
        myRenderer.drawCallback = function
    }

    fun render(scene: Scene, camera: PerspectiveCamera) {
        scene.children.forEach {
            it.draw()
        }
    }

    init {
        canvas.setRenderer(myRenderer)
    }
}