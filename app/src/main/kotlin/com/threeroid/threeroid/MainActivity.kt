package com.threeroid.threeroid

import android.app.Activity
import android.os.Bundle
import android.os.StrictMode
import com.threeroid.threeroid.cameras.PerspectiveCamera
import com.threeroid.threeroid.helper.GridHelper
import com.threeroid.threeroid.materials.MeshNormalMaterial
import com.threeroid.threeroid.objects.Mesh

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

        val scene = Scene()
        val camera = PerspectiveCamera(45, 0.5)
        camera.position.set(0f, 0f, 100f)

        val geometry = BoxGeometry(1f, 1f, 1f)
        val material = MeshNormalMaterial()
        val box = Mesh(geometry, material)
        box.position.set(0.0f, 0.0f, 0.0f)
        scene.add(box)

        var grid = GridHelper(100, 50)
        scene.add(grid)

//        val geometry2 = BoxGeometry(10f, 10f, 10f)
//        val material2 = MeshNormalMaterial()
//        val box2 = Mesh(geometry2, material2)
//        box2.position.set(-1.0f, -1.0f, -1.0f)
//        scene.add(box2)

        renderer.setRenderLoop(fun() {
            // requestAnimationFrame(render) : TODO check necessity
            box.position.x -= 0.0025f
            box.position.y -= 0.0025f
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
