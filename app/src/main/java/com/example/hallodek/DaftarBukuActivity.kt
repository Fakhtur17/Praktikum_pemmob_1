package com.example.hallodek

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hallodek.data.model.BookDoc
import com.example.hallodek.databinding.ActivityDaftarBukuBinding
import com.example.hallodek.viewmodel.MainViewModel
import com.example.hallodek.ui.adapter.BookAdapter
import com.example.hallodek.ui.adapter.onBookClickListener
import com.example.hallodek.ui.fragment.BookDetailFragment

class DaftarBukuActivity : AppCompatActivity(), onBookClickListener {

    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = BookAdapter(books = emptyList(),this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.books.observe(this) { list ->
            adapter.setData(list)
        }

        viewModel.fetchBooks(query = "kotlin programming")
    }

    override fun onBookClick(book: BookDoc) {
        book.let { b->
            BookDetailFragment(
                b.title?:"-",
                b.authorName?.joinToString(", ")?: "unknown author" ,
                "${b.firstPublishYear}",
                b.coverId?:0
            ).show(supportFragmentManager, BookDetailFragment::class.java.simpleName)
        }
    }
}
