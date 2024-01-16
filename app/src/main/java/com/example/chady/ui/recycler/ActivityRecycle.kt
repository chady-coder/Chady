package com.example.chady.ui.recycler

import com.example.chady.ui.device.ExempleAdapter
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chady.R

class ActivityRecycle : AppCompatActivity(){
    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, ActivityRecycle::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycle_activity)
        val items = mutableListOf("Fenêtre 1", "Fenêtre 2")
        val rvDevices = this.findViewById<RecyclerView>(R.id.rvDevices)

        rvDevices.layoutManager = LinearLayoutManager(this)
        rvDevices.adapter = ExempleAdapter(items) { item ->
            Toast.makeText(this@ActivityRecycle, "Connexion à $item", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            items.add("Fenêtre ${items.size + 1}")
            rvDevices.adapter?.notifyItemInserted(items.size - 1)
        }
    }
}
