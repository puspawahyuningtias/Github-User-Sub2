package com.puspawahyuningtias.githubuser.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.puspawahyuningtias.githubuser.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USERNAME ="extra_username"
    }
    private lateinit var binding: ActivityDetailUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}