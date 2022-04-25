package com.gizem.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.gizem.myproject.databinding.ActivityStartBinding


class StartActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_start)
        binding.signbutton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent : Intent = Intent(this,PremiumActivity::class.java)
        startActivity(intent)
    }

}