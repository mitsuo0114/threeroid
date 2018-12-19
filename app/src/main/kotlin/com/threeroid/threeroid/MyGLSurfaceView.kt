package com.threeroid.threeroid

import android.opengl.GLSurfaceView
import android.util.AttributeSet
import android.view.MotionEvent
import android.content.Context

class MyGLSurfaceView : GLSurfaceView {

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    constructor(context: Context) : super(context) {
        debugFlags = GLSurfaceView.DEBUG_CHECK_GL_ERROR or GLSurfaceView.DEBUG_LOG_GL_CALLS
        setEGLContextClientVersion(3)
        renderMode = GLSurfaceView.RENDERMODE_WHEN_DIRTY
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}
