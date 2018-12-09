package com.threeroid.threeroid

import android.opengl.GLSurfaceView

class OpenGLESRenderer{
    fun setRenderLoop(function: () -> Unit) {

    }

    fun render(scene: Scene, camera: PerspectiveCamera) {

    }

    constructor(canvas: GLSurfaceView, myRenderer: MyRenderer){
        canvas.setRenderer(myRenderer)
    }

}