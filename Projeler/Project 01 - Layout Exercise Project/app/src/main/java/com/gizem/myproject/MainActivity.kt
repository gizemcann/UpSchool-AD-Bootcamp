package com.gizem.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gizem.myproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

   private lateinit var binding: ActivityMainBinding
/*    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var constraintLayout: ConstraintLayout*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.startbutton.setOnClickListener (this)

    }

    override fun onClick(p0: View?) {
        val intent : Intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }
}