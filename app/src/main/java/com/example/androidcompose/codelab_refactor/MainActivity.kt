package com.example.androidcompose.codelab_refactor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcompose.R
import com.example.androidcompose.databinding.ActivityGardenBinding
import androidx.databinding.DataBindingUtil.setContentView

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityGardenBinding>(this, R.layout.activity_garden)
    }
}