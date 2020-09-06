package com.example.mymouse

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View


class MarioView(context: Context) : View(context) {

    //圖片位置的 X,Y 座標
    var bitmapX = 0f
    var bitmapY = 0f

    private val paint = Paint()

    //取得 bitmap 並 resize
    private val bitmap : Bitmap
        get() {
            val origin = BitmapFactory.decodeResource(this.resources, R.drawable.mario)
            return Bitmap.createScaledBitmap(origin, 60, 90, false)
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //繪製圖像
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        //判斷未被回收
        if (!bitmap.isRecycled) {
            //當確定點陣圖不被使用時，才可調用 recycle
            bitmap.recycle()
        }
    }
}