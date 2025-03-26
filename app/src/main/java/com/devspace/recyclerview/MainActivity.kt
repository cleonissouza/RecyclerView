package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.contracts.Returns

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListadapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }
        adapter.setOnClickListener { contact ->

            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }
    }


}

val contacts = listOf(
    Contact(
        "Amor",
        "(15) 15 91968070",
        R.drawable.img_4
    ),
    Contact(
        "Pai e mae",
        "(15) 15 23468070",
        R.drawable.img_2
    ),
    Contact(
        "Gaya",
        "+39  355 376 2455",
        R.drawable.img_10
    ),
    Contact(
        "Antonio",
        "(15) 15 87668070",
        R.drawable.img_1
    ),
    Contact(
        "Maria",
        "(15) 15 51868045",
        R.drawable.img_7
    ),
    Contact(
        "Denilson",
        "(15) 15 54968079",
        R.drawable.img_8
    ),
    Contact(
        "Roberto",
        "(44) 071968070",
        R.drawable.img_3
    ),
    Contact(
        "Lucas da Alemanha",
        "(44) 15 43968077",
        R.drawable.img_6
    ),
    Contact(
        "Leo",
        "(44) 15 56968066",
        R.drawable.img_9
    ),
    Contact(
        "Andre",
        "(15) 15 64968075",
        R.drawable.img_5
    ),
    Contact(
        "lisa",
        "(15) 15 76968070",
        R.drawable.sample16
    ),
    Contact(
        "ryan",
        "(15) 15 98968078",
        R.drawable.sample12
    ),
    Contact(
        "kaka",
        "(15) 15 43968070",
        R.drawable.sample15
    ),
    Contact(
        "bruna",
        "(15) 15 45968044",
        R.drawable.sample16
    ),
)