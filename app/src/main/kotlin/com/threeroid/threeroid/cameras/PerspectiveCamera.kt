package com.threeroid.threeroid.cameras

import com.threeroid.threeroid.math.Math as _Math
import java.lang.Math

class PerspectiveCamera(var fov: Float = 50f, var aspect: Float = 1f, var near: Float = 0.1f, var far: Float = 2000f) :
    Camera() {

    inner class ViewConfig(
        var enabled: Boolean = true,
        var fullWidth: Float = 1f,
        var fullHeight: Float = 1f,
        var offsetX: Float = 0f,
        var offsetY: Float = 0f,
        var width: Float = 1f,
        var height: Float = 1f
    )

    var view: ViewConfig = ViewConfig()
    var zoom: Float = 1f
    var focus: Float = 10f

    var filmGauge = 35f    // width of the film (default in millimeters)
    var filmOffset = 0f    // horizontal film offset (same unit as gauge)

    fun getFilmWidth(): Float {
        // film not completely covered in portrait format (aspect < 1)
        return (this.filmGauge * Math.min(this.aspect.toDouble(), 1.toDouble())).toFloat()
    }

    fun getFilmHeight(): Float {
        // film not completely covered in landscape format (aspect > 1)
        return (this.filmGauge / Math.max(this.aspect.toDouble(), 1.toDouble())).toFloat()
    }

    fun updateProjectionMatrix() {

        var near = this.near
        var top: Float = near * Math.tan((_Math.DEG2RAD * 0.5f * this.fov).toDouble()).toFloat() / this.zoom
        var height: Float = 2f * top
        var width: Float = this.aspect * height
        var left: Float = -0.5f * width
        var view = this.view

        if (this.view !== null && this.view.enabled) {

            var fullWidth = view.fullWidth
            var fullHeight = view.fullHeight

            left += view.offsetX * width / fullWidth
            top -= view.offsetY * height / fullHeight
            width *= view.width / fullWidth
            height *= view.height / fullHeight
        }

        var skew = this.filmOffset
        if (skew != 0f) left += near * skew / this.getFilmWidth()

        this.projectionMatrix.makePerspective(left, left + width, top, top - height, near, this.far)

        this.projectionMatrixInverse.getInverse(this.projectionMatrix)
    }
}
