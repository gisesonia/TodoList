package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //Substitui o R.layout do import do synthetic
    var binding: ActivityMainBinding? = null
    private lateinit var todoAdapter: TodoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        todoAdapter = TodoAdapter(mutableListOf())

        binding!!.rvTodoItems.adapter = todoAdapter
        binding!!.rvTodoItems.layoutManager = LinearLayoutManager(this)

        binding!!.btnAddTodo.setOnClickListener {
            val todoTitle = binding!!.etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                binding!!.etTodoTitle.text.clear()
            }
        }

        binding!!.btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}