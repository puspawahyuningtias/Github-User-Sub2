package com.puspawahyuningtias.githubuser.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.puspawahyuningtias.githubuser.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}