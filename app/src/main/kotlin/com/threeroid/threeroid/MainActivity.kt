package com.threeroid.threeroid

import android.opengl.GLES31
import android.app.Activity
import android.os.Bundle
import android.os.StrictMode
import java.nio.ByteBuffer
import java.nio.ByteOrder

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build())
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build())
        setContentView(R.layout.activity_main)


        // Example of a call to a native method
        //        sample_text.text = stringFromJNI()
    }
    override fun onResume() {
        super.onResume()
        val renderer = OpenGLESRenderer(findViewById(R.id.glmain_view), MyRenderer())
        //  renderer.setPixelRatio() TODO: check what this func do
        //  renerer.setSize() Don't have to use this.

        val scene = Scene();
        val camera = PerspectiveCamera(45, 0.5)
        camera.position.set(0f, 0f, 100f)

        val geometry = BoxGeometry(400f, 400f, 400f)
        val material = MeshNormalMaterial()
        val box = Mesh(geometry, material)
        box.position.set(300f, 300f, 300f)
        scene.add(box)

        val geometry2 = BoxGeometry(400f, 400f, 400f)
        val material2 = MeshNormalMaterial()
        val box2 = Mesh(geometry2, material2)
        box2.position.set(-300f, -300f, -300f)
        scene.add(box2)

        renderer.setRenderLoop(fun() {
            // requestAnimationFrame(render) : TODO check necessity
            // box.rotation.z += 0.01f
            renderer.render(scene, camera)
        })
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
