package com.threeroid.threeroid

import android.opengl.GLES31
import android.util.Log

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer

object GLES {

    private val VERTEX_CODE = """
        #version 310 es
        in vec4 v_Position;
        in lowp vec2 a_UV;
        out lowp vec2 v_UV;
        void main(){
            gl_Position = v_Position;
            v_UV = a_UV;
        }
    """
    private val FRAGMENT_CODE = """
        #version 310 es
        uniform lowp vec4 f_Color;
        uniform lowp sampler2D u_Tex;
        uniform bool use_texture;
        out lowp vec4 color;
        in lowp vec2 v_UV;
        void main(){
            if( use_texture ){
              color = texture(u_Tex,v_UV);
            }else{
              color = f_Color;
            }
        }
    """

    private val COMPUTE_CODE = """
        #version 310 es
        layout (local_size_x = 32, local_size_y = 32) in;
        void main(){
        // Do nothing
        }
    """

    private val TAG = "GLES"

    // システム
    private var program: Int = 0 // プログラムオブジェクト

    // ハンドル
    var positionHandle: Int = 0 // 位置ハンドル
    var uvHandle: Int = 0 // UVハンドル
    var texHandle: Int = 0 // テクスチャハンドル
    var colorHandle: Int = 0
    var texenableHandle: Int = 0
    var screenW: Int = 0
    var screenH: Int = 0

    // プログラムの生成
    fun makeProgram() {
        try {
            // シェーダーオブジェクトの生成
            val vertexShader = loadShader(GLES31.GL_VERTEX_SHADER, VERTEX_CODE)
            val fragmentShader = loadShader(GLES31.GL_FRAGMENT_SHADER, FRAGMENT_CODE)
            val computeShader = loadShader(GLES31.GL_COMPUTE_SHADER, COMPUTE_CODE)

            // プログラムオブジェクトの生成
            program = GLES31.glCreateProgram()
            GLES31.glAttachShader(program, vertexShader)
            GLES31.glAttachShader(program, fragmentShader)
            GLES31.glAttachShader(program, computeShader)
            GLES31.glLinkProgram(program)

            positionHandle = GLES31.glGetAttribLocation(program, "v_Position")
            colorHandle = GLES31.glGetUniformLocation(program, "f_Color")
            uvHandle = GLES31.glGetAttribLocation(program, "a_UV")
            texHandle = GLES31.glGetUniformLocation(program, "u_Tex")
            texenableHandle = GLES31.glGetUniformLocation(program, "use_texture")

            assert(positionHandle >= 0)
            assert(colorHandle >= 0)

            GLES31.glUseProgram(program)
        } catch (e: UnsatisfiedLinkError) {
            Log.e(TAG, e.message)
        }
    }

    // シェーダーオブジェクトの生成
    private fun loadShader(type: Int, shaderCode: String): Int {
        val shader = GLES31.glCreateShader(type)
        GLES31.glShaderSource(shader, shaderCode)
        GLES31.glCompileShader(shader)
        return shader
    }

    // UVバッファの生成
    fun makeUVBuffer(): FloatBuffer {
        val uvs = floatArrayOf(0.0f, 0.0f, // 左上
                0.0f, 1.0f, // 左下
                1.0f, 0.0f, // 右上
                1.0f, 1.0f) // 右下
        return makeFloatBuffer(uvs)
    }

    fun makeFloatArray(x: Float, y: Float, w: Float, h: Float, for_texture: Boolean = true): FloatArray {
        // ウィンドウ座標を正規化デバイス座標に変換
//        val left = x / screenW.toFloat() * 2.0f - 1.0f
//        var top = y / screenH.toFloat() * 2.0f - 1.0f
//        val right = (x + w) / screenW.toFloat() * 2.0f - 1.0f
//        var bottom = (y + h) / screenH.toFloat() * 2.0f - 1.0f
        val left = x / screenW.toFloat() * 2.0f
        var top = y / screenH.toFloat() * 2.0f
        val right = (x + w) / screenW.toFloat() * 2.0f
        var bottom = (y + h) / screenH.toFloat() * 2.0f
        top = -top
        bottom = -bottom

        // 頂点バッファの生成
        if (for_texture) {
            return floatArrayOf(left, top, 0.0f, // 頂点0
                    left, bottom, 0.0f, // 頂点1
                    right, top, 0.0f, // 頂点2
                    right, bottom, 0.0f) // 頂点3
        } else {
            return floatArrayOf(left, top, 0.0f, // 頂点0
                    left, bottom, 0.0f, // 頂点1
                    right, bottom, 0.0f, // 頂点2
                    right, top, 0.0f) // 頂点3
        }
    }

    // 頂点バッファの生成
    fun makeVertexBuffer(x: Float, y: Float, w: Float, h: Float): FloatBuffer {
        return makeFloatBuffer(makeFloatArray(x, y, w, h))
    }

    // float配列をFloatBufferに変換
    fun makeFloatBuffer(array: FloatArray): FloatBuffer {
        val fb = ByteBuffer.allocateDirect(array.size * 4).order(
                ByteOrder.nativeOrder()).asFloatBuffer()
        fb.put(array).position(0)
        return fb
    }
}