package com.gizem.tweenanimation

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gizem.tweenanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

 /*    private lateinit var image: ImageView
      private lateinit var button1: Button
       private lateinit var button2: Button
       private lateinit var button3: Button
       private lateinit var button4: Button
       private lateinit var button5: Button*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

/*        setContentView(R.layout.activity_main)
        image = findViewById(R.id.imageView2)
        button1 = findViewById(R.id.rotateButton)
        button2 = findViewById(R.id.alphaButton)
        button3 = findViewById(R.id.scaleButton)
        button4 = findViewById(R.id.moveButton)
        button5 = findViewById(R.id.allButton)*/



        binding.rotateButton.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.rotate)
            binding.imageView3.startAnimation(anim)
            //button.startAnimation(anim)
        }

        binding.alphaButton.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.alpha)
            binding.imageView3.startAnimation(anim)
        }

        binding.scaleButton.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.scale)
            binding.imageView3.startAnimation(anim)
        }

        binding.moveButton.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.translate)
            binding.imageView3.startAnimation(anim)
        }
        binding.allButton.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.all)
            binding.imageView3.startAnimation(anim)
        }
    }
}