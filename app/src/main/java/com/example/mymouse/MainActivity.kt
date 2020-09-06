package com.example.mymouse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val marioView = MarioView(this@MainActivity)
        superView.addView(marioView)

        //設定 觸摸後修改馬力歐的位置
        superView.setOnTouchListener { view, event ->
            //設定馬力歐的顯示位置
            marioView.bitmapX = event.x - 100
            marioView.bitmapY = event.y - 100

            //重繪
            marioView.invalidate()
            true
        }
    }
}