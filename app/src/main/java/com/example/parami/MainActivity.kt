package com.example.parami

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navegation: BottomNavigationView

    private val mOnNavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.itemFragment1 -> {
                supportFragmentManager.commit {
                    replace<FragmentHome>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("inicio_primer_fragmento")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemFragment2 -> {
                supportFragmentManager.commit {
                    replace<FragmentEmociones>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("inicio_segundo_fragmento")
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemFragment3 -> {
                supportFragmentManager.commit {
                    replace<FragmentCreditos>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("inicio_tercer_fragmento")
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        navegation = findViewById(R.id.navMenu)
        navegation.setOnNavigationItemSelectedListener (mOnNavMenu)

        supportFragmentManager.commit {
            replace<FragmentHome>(R.id.frameContainer)
            setReorderingAllowed(true)
            addToBackStack("inicio_primer_fragmento")
        }
    }
}