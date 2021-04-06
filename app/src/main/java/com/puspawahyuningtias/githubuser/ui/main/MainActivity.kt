package com.puspawahyuningtias.githubuser.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.View.GONE
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.puspawahyuningtias.githubuser.data.model.User
import com.puspawahyuningtias.githubuser.databinding.ActivityMainBinding
import com.puspawahyuningtias.githubuser.ui.detail.DetailUserActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MainAdapter()
        adapter.notifyDataSetChanged()

        adapter.setOnItemClickCallback(object : MainAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                Intent(this@MainActivity, DetailUserActivity::class.java).also {
                    it.putExtra(DetailUserActivity.EXTRA_USERNAME, data.login)
                    startActivity(it)
                }
            }

        })

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)

        binding.apply {
            rvUser.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUser.setHasFixedSize(true)
            rvUser.adapter = adapter

            etQuery.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    if (query.isEmpty()) {
                        return true
                    } else {
                        showLoading(true)
                        searchText.visibility = GONE
                        viewModel.setSearchUsers(query)
                        etQuery.clearFocus()
                    }
                    return true
                }
                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }

            })

//            etQuery.setOnKeyListener { v, keyCode, event ->
//                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
//                    searchUser()
//                    return@setOnKeyListener (true)
//                }
//                return@setOnKeyListener false
//            }
        }
        viewModel.getSearchUsers().observe(this,{
            if(it!=null){
                adapter.setList(it)
                showLoading(false)
            }
        })
    }

//    private fun searchUser(){
//        binding.apply {
//            val query = etQuery.text.toString()
//            if (query.isEmpty()) return
//            showLoading(true)
//            viewModel.setSearchUsers(query)
//        }
//    }
    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}